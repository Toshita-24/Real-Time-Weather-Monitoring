package com.examplerealtimeweathermonitoring.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplerealtimeweathermonitoring.model.DailyWeatherSummary;
import com.examplerealtimeweathermonitoring.repository.DailyWeatherSummaryRepository;
import com.examplerealtimeweathermonitoring.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private DailyWeatherSummaryRepository dailyWeatherSummaryRepository;

    @GetMapping("/fetch")
    public String fetchWeatherData() {
        weatherService.fetchAndStoreWeatherData();
        return "Weather data fetched!";
    }

    @GetMapping("/summary/{city}")
    public List<DailyWeatherSummary> getDailySummary(@PathVariable String city) {
        return dailyWeatherSummaryRepository.findByCityAndDate(city, LocalDate.now());
    }
    @GetMapping("/summary/dominant/{city}")
    public Optional<DailyWeatherSummary> getDailySummaryWithDominantCondition(@PathVariable String city) {
        // Fetch the daily summary with dominant condition for the specified city
        return dailyWeatherSummaryRepository.findTopByCityAndDateOrderByDateDesc(city, LocalDate.now());
    }
    
}
