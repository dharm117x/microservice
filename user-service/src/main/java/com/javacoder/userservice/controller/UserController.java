package com.javacoder.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javacoder.userservice.dto.DepartmentDto;
import com.javacoder.userservice.dto.UserResponse;
import com.javacoder.userservice.entity.User;
import com.javacoder.userservice.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired 
	UserService service;
	
	@Autowired
	RestTemplate template;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		
		return service.saveUSer(user);
	}
	
	@GetMapping("{userId}")
	public UserResponse getuserInfo(@PathVariable Long userId) {
		User user = service.getUserById(userId);
		DepartmentDto departmentDto = template.getForObject("http://localhost:9191/departments/1", DepartmentDto.class);
		UserResponse res = new UserResponse();
//		res.setUser(user);
		res.setDept(departmentDto);
		return res;
	}
	
}
