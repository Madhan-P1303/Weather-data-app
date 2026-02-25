package com.weather.service;

import com.opencsv.CSVReader;
import com.weather.entity.Weather;
import com.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvService {

    private final WeatherRepository repository;

    public void loadCsv(MultipartFile file) throws Exception {

        CSVReader reader = new CSVReader(
                new InputStreamReader(file.getInputStream())
        );

        String[] line;
        reader.readNext(); 

        
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

        List<Weather> batch = new ArrayList<>();

        while ((line = reader.readNext()) != null) {

            try {

                LocalDateTime dateTime =
                        LocalDateTime.parse(line[0], formatter);

                Weather weather = Weather.builder()
                        .datetimeUtc(dateTime)
                        .weatherCondition(line[1])
                        .temperature(parse(line[12]))
                        .humidity(parse(line[6]))
                        .pressure(parse(line[8]))
                        .heatIndex(parse(line[5]))
                        .build();

                batch.add(weather);

                if (batch.size() == 1000) {
                    repository.saveAll(batch);
                    batch.clear();
                }

            } catch (Exception e) {
                System.out.println("Skipping row: " + e.getMessage());
            }
        }

        if (!batch.isEmpty()) {
            repository.saveAll(batch);
        }

        System.out.println("CSV Data Inserted Successfully!");
    }

    private Double parse(String value) {
        if (value == null || value.equals("-9999") || value.isEmpty())
            return null;
        return Double.parseDouble(value);
    }
}