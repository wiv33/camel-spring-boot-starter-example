package com.example.camel.components.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class WeatherDto implements Serializable {
  static int counter = 1;

  private int id = counter++;
  private String city;
  private String temp;
  private String unit;
  private String receivedTime;

  public WeatherDto(int id, String city, String temp, String unit, String receivedTime) {
    this.id = id;
    this.city = city;
    this.temp = temp;
    this.unit = unit;
    this.receivedTime = receivedTime;
  }
}
