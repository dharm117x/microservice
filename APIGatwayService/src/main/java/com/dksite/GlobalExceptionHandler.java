package com.dksite;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String excepionHandler(Exception ex) {
		System.out.println("GlobalExceptionHandler.excepionHandler()");
		return ex.getMessage();
	}
}
