package com.javacoder.apigatwayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class ApiGatwayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatwayServiceApplication.class, args);
	}

}
