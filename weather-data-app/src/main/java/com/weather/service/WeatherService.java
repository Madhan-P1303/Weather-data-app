package com.weather.service;

import com.weather.entity.Weather;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface WeatherService {

    List<Weather> getWeatherByDate(LocalDate date, String sortBy);

    List<Weather> getWeatherByMonth(int year, int month, String sortBy);

    Map<String, Double> getMonthlyTemperatureStats(int year, int month);
}