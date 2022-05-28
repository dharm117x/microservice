package com.javacoder.userservice.dto;

public class UserResponse {
	private UserDto user;
	private DepartmentDto dept;

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public DepartmentDto getDept() {
		return dept;
	}

	public void setDept(DepartmentDto dept) {
		this.dept = dept;
	}

}
