package com.examplerealtimeweathermonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RealTimeWeatherMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeWeatherMonitoringApplication.class, args);
		System.out.println("Real Time Weather Monitroring");
	}

}
