package com.example.camel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CamelApplication {

	public static void main(String[] args) throws Exception {
		Main main = new Main(CamelApplication.class);
		main.run(args);
	}


	@Component
	public static class MyRouteBuilder extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			from("timer:foo?period=5000&delay=2000&fixedRate=true&daemon=true")
					.transform().simple("Current time is ${header.firedTime}")
					.process()
					.exchange(this::log)
					.to("http://localhost:8080/api/hello?body=foo");

		}

		private void log(Exchange exchange) {
			System.out.println("exchange = " + exchange);
		}
	}


}
