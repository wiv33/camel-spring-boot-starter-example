package com.example.camel.components.builders;

import com.example.camel.components.dto.WeatherDto;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component
public class WeatherDataProvider {
  public static Map<String, WeatherDto> weatherDtoMap = new HashMap<>();

  public WeatherDataProvider() {
    weatherDtoMap.put("LONDON", new WeatherDto(1, "London", "10", "C", "2020-01-01 10:00:00"));
    weatherDtoMap.put("PARIS", new WeatherDto(2, "Paris", "20", "C", "2020-01-01 10:00:00"));
    weatherDtoMap.put("NEW YORK", new WeatherDto(3, "New York", "30", "C", "2020-01-01 10:00:00"));
    weatherDtoMap.put("TOKYO", new WeatherDto(4, "Tokyo", "40", "C", "2020-01-01 10:00:00"));
    weatherDtoMap.put("SYDNEY", new WeatherDto(5, "Sydney", "50", "C", "2020-01-01 10:00:00"));
  }

  public WeatherDto getCurrentWeather(String city) {
    return weatherDtoMap.get(city.toUpperCase(Locale.ROOT));
  }

  public void setCurrentWeather(String city, WeatherDto weatherDto) {
    weatherDtoMap.put(city.toUpperCase(Locale.ROOT), weatherDto);
  }

}
