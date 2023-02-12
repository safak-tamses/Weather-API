package com.example.weatherapi.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityCoordinate implements Serializable {
    private double lon;
    private double lat;
    private String country;
}
