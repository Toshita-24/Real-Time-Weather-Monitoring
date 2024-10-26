package com.examplerealtimeweathermonitoring.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class DailyWeatherSummary {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String city;
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		public double getAvgTemp() {
			return avgTemp;
		}
		public void setAvgTemp(double avgTemp) {
			this.avgTemp = avgTemp;
		}
		public double getMaxTemp() {
			return maxTemp;
		}
		public void setMaxTemp(double maxTemp) {
			this.maxTemp = maxTemp;
		}
		public double getMinTemp() {
			return minTemp;
		}
		public void setMinTemp(double minTemp) {
			this.minTemp = minTemp;
		}
		public String getDominantCondition() {
			return dominantCondition;
		}
		public void setDominantCondition(String dominantCondition) {
			this.dominantCondition = dominantCondition;
		}
		private LocalDate date;
	    private double avgTemp;
	    private double maxTemp;
	    private double minTemp;
	    private String dominantCondition;
	    
	    // Getters, setters, and constructor
	}


