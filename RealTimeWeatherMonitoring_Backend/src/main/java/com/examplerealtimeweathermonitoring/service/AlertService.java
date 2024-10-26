package com.examplerealtimeweathermonitoring.service;

import org.springframework.stereotype.Service;

import com.examplerealtimeweathermonitoring.model.WeatherData;

@Service


public class AlertService {

	
	    
	    private final double TEMP_THRESHOLD = 35.0;  // example threshold

	    public void checkForAlerts(WeatherData weatherData) {
	        if (weatherData.getTempCelsius() > TEMP_THRESHOLD) {
	            triggerAlert(weatherData);
	        }
	    }

	    private void triggerAlert(WeatherData weatherData) {
	        System.out.println("Alert! High temperature in " + weatherData.getCity() + ": " + weatherData.getTempCelsius() + "°C");
	        // Optionally: send an email or push notification.
	    }
	}

