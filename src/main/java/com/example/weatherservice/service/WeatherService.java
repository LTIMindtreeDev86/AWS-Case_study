package com.example.weatherservice.service;

import com.example.weatherservice.model.Weather;
import com.example.weatherservice.repository.dynamodb.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WeatherService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private WeatherRepository weatherRepository;

    public Weather getWeatherByCity(String city) {
        return weatherRepository.findByCity(city);
    }

    public Weather saveWeather(Weather weather) {
        logger.info("Saving weather: {}", weather);
        return weatherRepository.save(weather);
    }

    public Weather fetchAndSaveWeather(String city) {
        Weather weather = getWeatherByCity(city);
        if (weather != null) {
            saveWeather(weather);
        }
        return weather;
    }
}