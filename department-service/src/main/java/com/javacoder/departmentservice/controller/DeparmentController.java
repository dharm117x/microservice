package com.javacoder.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacoder.departmentservice.dto.DepartmentDto;
import com.javacoder.departmentservice.facade.DepartmentFacade;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DeparmentController {

	@Autowired DepartmentFacade facade;

	@PostMapping("/")
	public DepartmentDto saveDepartment(@ RequestBody DepartmentDto dto) {
		log.info("Save deparment");
		return facade.saveDepartment(dto);
	}
	
	@GetMapping("{depId}")
	public DepartmentDto getDepartment(@PathVariable Long depId) {
		log.info("get Department by dept id");
		return facade.getDepartmentById(depId);
	}
	
}
