package com.javacoder.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacoder.departmentservice.entity.Department;
import com.javacoder.departmentservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DeparmentController {

	@Autowired DepartmentService service;

	@PostMapping("/")
	public Department saveDepartment(@ RequestBody Department dep) {
		System.out.println("DeparmentController.saveDepartment()");
		return service.saveDepartment(dep);
	}
	
	@GetMapping("{depId}")
	public Department getDepartment(@PathVariable Long depId) {
		System.out.println("DeparmentController.getDepartment()");
		return service.getDepartmentById(depId);
	}
	
}
