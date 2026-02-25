package com.weather.service.impl;

import com.weather.entity.Weather;
import com.weather.repository.WeatherRepository;
import com.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    @Override
    public List<Weather> getWeatherByDate(LocalDate date, String sortBy) {

        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(23, 59, 59);

        return repository.findByDatetimeUtcBetween(
                start,
                end,
                Sort.by(sortBy)
        );
    }

    @Override
    public List<Weather> getWeatherByMonth(int year, int month, String sortBy) {

        LocalDateTime start = LocalDate.of(year, month, 1).atStartOfDay();
        LocalDateTime end = start.plusMonths(1).minusSeconds(1);

        return repository.findByDatetimeUtcBetween(
                start,
                end,
                Sort.by(sortBy)
        );
    }

    @Override
    public Map<String, Double> getMonthlyTemperatureStats(int year, int month) {

        List<Double> temps =
                repository.findTemperaturesByYearAndMonth(year, month);

        Collections.sort(temps);

        double min = temps.get(0);
        double max = temps.get(temps.size() - 1);

        double median;
        int size = temps.size();

        if (size % 2 == 0)
            median = (temps.get(size/2 - 1) + temps.get(size/2)) / 2;
        else
            median = temps.get(size/2);

        Map<String, Double> result = new HashMap<>();
        result.put("min", min);
        result.put("median", median);
        result.put("max", max);

        return result;
    }
}