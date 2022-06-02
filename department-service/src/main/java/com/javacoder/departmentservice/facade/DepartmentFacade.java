package com.javacoder.departmentservice.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javacoder.departmentservice.convertor.DepartmentConvertor;
import com.javacoder.departmentservice.dto.DepartmentDto;
import com.javacoder.departmentservice.entity.Department;
import com.javacoder.departmentservice.service.DepartmentService;

@Service
public class DepartmentFacade {

	@Autowired
	DepartmentService service;
	
	@Autowired
	DepartmentConvertor convertor;
	
	public DepartmentDto saveDepartment(DepartmentDto dto) {
		Department entity = convertor.dataToEntity(dto);
		return convertor.entityToData(service.saveDepartment(entity));
	}

	public DepartmentDto getDepartmentById(Long depId) {
		return convertor.entityToData(service.getDepartmentById(depId));
	}

}
