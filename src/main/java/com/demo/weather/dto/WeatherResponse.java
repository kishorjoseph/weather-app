package com.demo.weather.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherResponse {
    @JsonProperty("list")
    private List<CityData> cities;

    public List<CityData> getCities() {
        return  cities != null ? cities : List.of();
    }

    public void setCities(List<CityData> cities) {
        this.cities = cities;
    }
}
