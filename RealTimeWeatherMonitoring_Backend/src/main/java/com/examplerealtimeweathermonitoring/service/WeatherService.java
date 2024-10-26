package com.examplerealtimeweathermonitoring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;


import com.examplerealtimeweathermonitoring.model.DailyWeatherSummary;
import com.examplerealtimeweathermonitoring.model.WeatherData;
import com.examplerealtimeweathermonitoring.repository.DailyWeatherSummaryRepository;
import com.examplerealtimeweathermonitoring.repository.WeatherDataRepository;
import com.examplerealtimeweathermonitoring.utils.WeatherUtils;

@Service

public class WeatherService {
	    
	    @Value("${openweathermap.api.key}")
	    private String apiKey;

	    @Autowired
	    private WeatherDataRepository weatherDataRepository;

	    @Autowired
	    private DailyWeatherSummaryRepository dailyWeatherSummaryRepository;

	    private final RestTemplate restTemplate = new RestTemplate();
	    
	    private static final String[] CITIES = {"Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad"};

	    public void fetchAndStoreWeatherData() {
	        for (String city : getCities()) {
	            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
	            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
	            if (response.getStatusCode() == HttpStatus.OK) {
	                processWeatherResponse(response.getBody(), city);
	            }
	        }
	    }

	    private void processWeatherResponse(String responseBody, String city) {
	        // Parse the JSON response
	        JSONObject json = new JSONObject(responseBody);
	        double tempKelvin = json.getJSONObject("main").getDouble("temp");
	        double feelsLikeKelvin = json.getJSONObject("main").getDouble("feels_like");
	        String mainCondition = json.getJSONArray("weather").getJSONObject(0).getString("main");
	        long dt = json.getLong("dt");

	        // Convert Kelvin to Celsius
	        double tempCelsius = WeatherUtils.kelvinToCelsius(tempKelvin);
	        double feelsLikeCelsius = WeatherUtils.kelvinToCelsius(feelsLikeKelvin);

	        // Store the weather data
	        WeatherData weatherData = new WeatherData();
	        weatherData.setCity(city);
	        weatherData.setTempCelsius(tempCelsius);
	        weatherData.setFeelsLikeCelsius(feelsLikeCelsius);
	        weatherData.setMainCondition(mainCondition);
	        weatherData.setTimestamp(LocalDateTime.ofEpochSecond(dt, 0, ZoneOffset.UTC));

	        weatherDataRepository.save(weatherData);
	    }

	    public void generateDailySummary(String city) {
	        LocalDate today = LocalDate.now();
	        List<WeatherData> dataList = weatherDataRepository.findByCityAndTimestampBetween(city, 
	                today.atStartOfDay(), today.plusDays(1).atStartOfDay());

	        double avgTemp = dataList.stream().mapToDouble(WeatherData::getTempCelsius).average().orElse(0);
	        double maxTemp = dataList.stream().mapToDouble(WeatherData::getTempCelsius).max().orElse(0);
	        double minTemp = dataList.stream().mapToDouble(WeatherData::getTempCelsius).min().orElse(0);
	        String dominantCondition = dataList.stream()
	            .collect(Collectors.groupingBy(WeatherData::getMainCondition, Collectors.counting()))
	            .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

	        DailyWeatherSummary summary = new DailyWeatherSummary();
	        summary.setCity(city);
	        summary.setDate(today);
	        summary.setAvgTemp(avgTemp);
	        summary.setMaxTemp(maxTemp);
	        summary.setMinTemp(minTemp);
	        summary.setDominantCondition(dominantCondition);

	        dailyWeatherSummaryRepository.save(summary);
	    }
	    public String determineDominantCondition(List<String> weatherConditions) {
	        // Count occurrences of each weather condition
	        Map<String, Long> conditionCounts = weatherConditions.stream()
	            .collect(Collectors.groupingBy(condition -> condition, Collectors.counting()));

	        // Find the condition with the maximum occurrences
	        return Collections.max(conditionCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
	    }

		public static String[] getCities() {
			return CITIES;
		}
	}


