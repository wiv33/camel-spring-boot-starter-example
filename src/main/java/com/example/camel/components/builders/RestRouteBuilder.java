package com.example.camel.components.builders;

import com.example.camel.components.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.DefaultMessage;
import org.springframework.stereotype.Component;

@Component
public class RestRouteBuilder extends RouteBuilder {


  // http://localhost:8080/api/hello
  @Override
  public void configure() throws Exception {
//    from("timer:foo?period=5000")
//        .outputType(WeatherDto.class)
//        .process(this::getWeatherData)
//        .to("log:out")
    ;
  }

  private void getWeatherData(Exchange exchange) {
    var city = exchange.getIn().getHeader("LONDON", String.class);
    var weatherDataProvider = new WeatherDataProvider();
    System.out.println("city = " + city);
    var currentWeather = weatherDataProvider.getCurrentWeather(city);
//
    exchange.getIn().setBody(currentWeather);

    var message = new DefaultMessage(exchange.getContext());
    message.setBody(city);
    exchange.setMessage(message);

  }

}
