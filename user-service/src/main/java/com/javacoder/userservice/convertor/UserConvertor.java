package com.javacoder.userservice.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javacoder.userservice.dto.UserDto;
import com.javacoder.userservice.entity.User;

@Service
public class UserConvertor {

	public UserDto userToUserDto(User user) {
		UserDto dto = new UserDto();
		dto.setEmail(user.getEmail());
		dto.setName(user.getName());
		dto.setPhone(user.getPhone());

		return dto;
	}
	
	public User userDtoToUser(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setPhone(dto.getPhone());
		
		return user;
	}
	
	public List<UserDto> userToUserDto(List<User> users) {
		return users.stream().map(u -> userToUserDto(u)).collect(Collectors.toList());
	}

	public List<User> userDtoToUser(List<UserDto> dtos) {
		return dtos.stream().map(d -> userDtoToUser(d)).collect(Collectors.toList());
	}
	
}
