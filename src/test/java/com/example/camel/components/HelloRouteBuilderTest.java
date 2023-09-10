package com.example.camel.components;

import com.example.camel.CamelApplication;
import org.apache.camel.ProducerTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CamelApplication.class, properties = "camel.routes.hello.enabled=true")
class HelloRouteBuilderTest {

  @Autowired
  ProducerTemplate template;

  @Test
  void testMockAreValid() {
    template.sendBody("direct:greeting", "World");
    template.sendBody("direct:greeting", "Camel");
    template.sendBody("direct:start", "Camel");
  }
}