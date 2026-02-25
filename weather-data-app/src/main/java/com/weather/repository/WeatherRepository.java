package com.weather.repository;

import com.weather.entity.Weather;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    List<Weather> findByDatetimeUtcBetween(
            LocalDateTime start,
            LocalDateTime end,
            Sort sort
    );

    @Query("""
            SELECT w.temperature
            FROM Weather w
            WHERE YEAR(w.datetimeUtc) = :year
            AND MONTH(w.datetimeUtc) = :month
            AND w.temperature IS NOT NULL
            """)
    List<Double> findTemperaturesByYearAndMonth(int year, int month);
}