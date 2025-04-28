package com.demo.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityData {
    private String name;

    public String getName() {
        return name != null ? name.trim() : null;
    }
}