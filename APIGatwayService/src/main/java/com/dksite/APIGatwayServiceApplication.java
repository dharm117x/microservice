package com.dksite;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dksite.filter.AuthorizationHeaderFilter;

@SpringBootApplication
public class APIGatwayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(APIGatwayServiceApplication.class, args);
	}
	

	@Bean(name = "authorizationHeaderFilter")
	public AuthorizationHeaderFilter authorizationHeaderFilter() {
		
	return new AuthorizationHeaderFilter();
	}	
}
