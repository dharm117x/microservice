package com.dksite.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dksite.data.UserDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {
	final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private RestTemplate tempalte;
	@Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

	
	List<UserDTO> dtos = new ArrayList<UserDTO>();
	{
		UserDTO user = new UserDTO(0, "DK Sharma");
		dtos.add(user );
	}

	@GetMapping("/all")
	public List<UserDTO> getUsers() {
		
		return dtos;
	}
	
	@GetMapping("/department")
	@CircuitBreaker(name = "DEPARTMENTSERVICE", fallbackMethod = "fallbackDepartment")
	public ResponseEntity<String> getDepartment() {

		return tempalte.getForEntity("http://DEPARTMENT-SERVICE/departments/all", String.class);
	}
	
	@GetMapping("/departments")
	public ResponseEntity<String> getDepartments() {
		org.springframework.cloud.client.circuitbreaker.CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		return circuitBreaker.run(() -> tempalte.getForEntity("http://DEPARTMENT-SERVICE/departments/all", String.class));
	}
	
	public String fallbackDepartment(Exception e) {
		LOG.info("Excep:: ", e);
		return "Dummy depts";
		
	}
}
