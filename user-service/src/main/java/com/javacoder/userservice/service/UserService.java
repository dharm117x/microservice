package com.javacoder.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacoder.userservice.entity.User;
import com.javacoder.userservice.repositroy.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository repository;

	public User saveUSer(User user) {
		return repository.save(user);
	}
	
	public List<User> getUsers() {
		return repository.findAll();
	}

	public User getUserById(Long userId) {
		return repository.findByUserId(userId);
	}
}
