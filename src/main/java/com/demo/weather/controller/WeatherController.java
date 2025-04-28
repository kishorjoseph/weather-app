package com.demo.weather.controller;

import com.demo.weather.dto.CountRespose;
import com.demo.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<?> getWeatherData() {
        try {
            return ResponseEntity.ok(weatherService.fetchWeatherData());
        }catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error fetching weather data " + e.getMessage());
        }
    }
    @GetMapping("/citycount")
    public ResponseEntity<?> getCityCount(@RequestParam String cityname) {
        try {
            int count = weatherService.countNameOccurrences(cityname);
            return ResponseEntity.ok(new CountRespose(count, cityname));
        }catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(new CountRespose(0,"Error"));
        }
    }
}
