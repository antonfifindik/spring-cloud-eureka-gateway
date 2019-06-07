package com.antonfifindik.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()

				.route("client-service", r -> r
				.path("/clients/**")
				.uri("lb://client-service"))

				.route("bot-service", r -> r
				.path("/bots/**")
				.uri("lb://bot-service"))

				.build();

//				.route("Get all clients", r -> r
//				.method(HttpMethod.GET)
//				.and()
//				.path("/client-service/clients")
//				.filters(f -> f.addRequestHeader("Hello", "World"))
//				.uri("http://localhost:8086"))
//
//				.route("Get client", r -> r
//				.method(HttpMethod.GET)
//				.and()
//				.path("/client-service/clients/{clientId}")
//				.uri("http://localhost:8086"))
//
//				.route("Delete client by id", r -> r
//				.method(HttpMethod.DELETE)
//				.and()
//				.path("/client-service/clients/{clientId}")
//				.uri("http://localhost:8086"))
//
//				.route("Delete client", r -> r
//				.method(HttpMethod.DELETE)
//				.and()
//				.path("/client-service/clients/client")
//				.uri("http://localhost:8086"))
//
//				.route("Delete all clients", r -> r
//				.method(HttpMethod.DELETE)
//				.and()
//				.path("/client-service/clients")
//				.uri("http://localhost:8086"))
//
//				.route("Save client", r -> r
//				.method(HttpMethod.POST)
//				.and()
//				.path("/client-service/clients/client")
//				.uri("http://localhost:8086"))
//
//				.route("Save clients", r -> r
//				.method(HttpMethod.POST)
//				.and()
//				.path("/client-service/clients")
//				.uri("http://localhost:8086"))
//
//				.route("Get count of clients", r -> r
//				.method(HttpMethod.GET)
//				.and()
//				.path("/client-service/clients/count")
//				.uri("http://localhost:8086"))
//
//				.route("Is client exist?", r -> r
//				.method(HttpMethod.GET)
//				.and()
//				.path("/client-service/clients/exist/{clientId}")
//				.uri("http://localhost:8086"))
//
//			.build();
	}

}
