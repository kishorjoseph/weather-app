package com.demo.weather.service;

import com.demo.weather.dto.CityData;
import com.demo.weather.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    private static final String WEATHER_API_URL =
            "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";
    public Object fetchWeatherData() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(WEATHER_API_URL, Object.class);
    }

    public int countNameOccurrences(String name) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(WEATHER_API_URL, WeatherResponse.class);

        if (response == null || response.getCities() == null) {
            return 0;
        }

        String searchName = name.toLowerCase();
        int count = 0;

        for (CityData city : response.getCities()) {
            if (city.getName() != null &&
                    city.getName().toLowerCase().equals(searchName))
                     {
                count++;
            }
        }

        return count;
    }
}
