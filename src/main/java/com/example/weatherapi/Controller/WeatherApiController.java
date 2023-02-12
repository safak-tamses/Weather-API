package com.example.weatherapi.Controller;

import com.example.weatherapi.Service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//localhost:8080/{name}/time
@RestController
@RequestMapping("/weather")
public class WeatherApiController {
    private final WeatherService weatherService;

    public WeatherApiController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity getWeather(@RequestParam String city, @RequestParam String interval){

        return weatherService.getWeather(city,interval);

    }


}
