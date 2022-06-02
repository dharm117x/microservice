package com.javacoder.departmentservice.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javacoder.departmentservice.dto.DepartmentDto;
import com.javacoder.departmentservice.entity.Department;

@Service
public class DepartmentConvertor {

	public DepartmentDto entityToData(Department dep) {
		DepartmentDto dto = new DepartmentDto();
		return dto;
	}
	
	public Department dataToEntity(DepartmentDto dto) {
		Department dep = new Department();
		return dep;
	}
	
	public List<DepartmentDto> entityToData(List<Department> departments) {
		return departments.stream().map(d -> entityToData(d)).collect(Collectors.toList());
	}

	public List<Department> dataToEntity(List<DepartmentDto> dtos) {
		return dtos.stream().map(d -> dataToEntity(d)).collect(Collectors.toList());
	}

}
