package com.dksite;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.RequestInterceptor;
import feign.Retryer;
import feign.codec.ErrorDecoder;

public class FiegnClientConfiguration {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			requestTemplate.header("user", "admin");
			requestTemplate.header("password", "admin");
			requestTemplate.header("Accept", org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());
		};
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}

	@Bean
	public Retryer clientServiceRetryer() {
		return new FeignClientRetryer();
	}
	
	@Bean
	public Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
