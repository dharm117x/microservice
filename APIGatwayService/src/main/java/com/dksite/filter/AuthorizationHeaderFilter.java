package com.dksite.filter;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import com.google.common.net.HttpHeaders;

import reactor.core.publisher.Mono;

public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {
	final org.slf4j.Logger LOG = LoggerFactory.getLogger(AuthorizationHeaderFilter.class);

	public static class Config {
		Boolean isSecure;

		public Boolean getIsSecure() {
			return isSecure;
		}

		public void setIsSecure(Boolean isSecure) {
			this.isSecure = isSecure;
		}
		
	}


	public AuthorizationHeaderFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			LOG.info("Config:: "+config.isSecure);
			ServerHttpRequest request = exchange.getRequest();
			if (config.getIsSecure().booleanValue() &&  !request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				return onError(exchange, "No authorization header", HttpStatus.UNAUTHORIZED);
			}
			
			return chain.filter(exchange);
		};
	}

	private Mono<Void> onError(ServerWebExchange exchange, String error, HttpStatus status) {
		ServerHttpResponse response = exchange.getResponse();
		response.setStatusCode(status);
		return response.setComplete();
	}
	
}
