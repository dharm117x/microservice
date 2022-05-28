package com.javacoder.userservice.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacoder.userservice.convertor.UserConvertor;
import com.javacoder.userservice.dto.UserDto;
import com.javacoder.userservice.entity.User;
import com.javacoder.userservice.service.UserService;

@Service
public class UserFacade {

	@Autowired
	UserService service;
	@Autowired
	UserConvertor convertor;
	
	public UserDto saveUser(UserDto dto) {
		User user = convertor.userDtoToUser(dto);
		User user2 = service.saveUser(user);
		return convertor.userToUserDto(user2);
	}

	public UserDto getUserById(Long userId) {
		User user = service.getUserById(userId);
		return convertor.userToUserDto(user);
	}
}
