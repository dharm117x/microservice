package com.dksite.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfiguration {

	static Logger log = LoggerFactory.getLogger(GlobalFilterConfiguration.class);

	@Order(1)
	@Bean
	public GlobalFilter firstFilter() {

		return (exchange, chain) -> {
			log.info("Pre first filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("Post first filter");
			}));

		};
	}
	

	@Order(2)
	@Bean
	public GlobalFilter secondFilter() {

		return (exchange, chain) -> {
			log.info("Pre second filter");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("Post second filter");
			}));

		};
	}

}
