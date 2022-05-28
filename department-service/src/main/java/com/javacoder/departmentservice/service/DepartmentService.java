package com.javacoder.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacoder.departmentservice.entity.Department;
import com.javacoder.departmentservice.repositroy.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired 
	DepartmentRepository repository;
	
	public Department saveDepartment(Department dep) {
		return repository.save(dep);
	}

	
	public List<Department> getDepartments() {
		return repository.findAll();
	}

	public Department getDepartmentById(Long depId) {
		return repository.findByDepId(depId);
	}
}
