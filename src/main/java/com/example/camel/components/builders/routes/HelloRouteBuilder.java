package com.example.camel.components.builders.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "camel.routes.hello.enabled", havingValue = "true")
public class HelloRouteBuilder extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("direct:greeting")
        .log("Hello ${body}");
  }
}
