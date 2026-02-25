package com.weather.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datetime_utc")
    private LocalDateTime datetimeUtc;

    @Column(name = "weather_condition")
    private String weatherCondition;

    private Double temperature;
    private Double humidity;
    private Double pressure;

    @Column(name = "heat_index")
    private Double heatIndex;
}