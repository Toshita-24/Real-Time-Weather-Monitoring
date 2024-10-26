 package com.examplerealtimeweathermonitoring.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplerealtimeweathermonitoring.model.DailyWeatherSummary;

@Repository
	public interface DailyWeatherSummaryRepository extends JpaRepository<DailyWeatherSummary, Long> {
	    List<DailyWeatherSummary> findByCityAndDate(String city, LocalDate date);
	    Optional<DailyWeatherSummary> findTopByCityAndDateOrderByDateDesc(String city, LocalDate date);

	}


