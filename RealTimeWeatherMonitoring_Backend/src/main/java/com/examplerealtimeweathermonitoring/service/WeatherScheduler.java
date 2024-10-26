package com.examplerealtimeweathermonitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component


public class WeatherScheduler {
	

	    @Autowired
	    private WeatherService weatherService;

	    @Scheduled(fixedRate = 300000)  // Every 5 minutes
	    public void fetchWeatherData() {
	        weatherService.fetchAndStoreWeatherData();
	    }

	    @Scheduled(cron = "0 0 0 * * ?")  // Every day at midnight
	    public void generateDailySummaries() {
	        for (String city : WeatherService.getCities()) {
	            weatherService.generateDailySummary(city);
	        }
	    }
	}


