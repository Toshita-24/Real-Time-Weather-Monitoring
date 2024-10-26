package com.examplerealtimeweathermonitoring.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class WeatherData {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String city;
	    private double tempCelsius;
	    private double feelsLikeCelsius;
	    private String mainCondition;
	    private LocalDateTime timestamp;
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public double getTempCelsius() {
			return tempCelsius;
		}
		public void setTempCelsius(double tempCelsius) {
			this.tempCelsius = tempCelsius;
		}
		public double getFeelsLikeCelsius() {
			return feelsLikeCelsius;
		}
		public void setFeelsLikeCelsius(double feelsLikeCelsius) {
			this.feelsLikeCelsius = feelsLikeCelsius;
		}
		public String getMainCondition() {
			return mainCondition;
		}
		public void setMainCondition(String mainCondition) {
			this.mainCondition = mainCondition;
		}
		public LocalDateTime getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}
		
	    // Getters, setters, and constructor
	}

