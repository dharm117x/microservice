package com.dksite;

import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class FeignRequestInterceptor implements RequestInterceptor{

	@Override
	public void apply(RequestTemplate template) {
		template.header("test-h", "Hello fiegn");
	}

}
