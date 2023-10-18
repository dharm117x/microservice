package com.dksite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dksite.data.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {
	List<UserDTO> dtos = new ArrayList<UserDTO>();
	
	{
		UserDTO user = new UserDTO(0, "DK Sharma");
		dtos.add(user );
	}

	@GetMapping("/all")
	public List<UserDTO> getUsers() {
		
		return dtos;
	}
}
