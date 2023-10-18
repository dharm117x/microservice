package com.dksite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dksite.data.DepartmentDTO;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	List<DepartmentDTO> dtos = new ArrayList<DepartmentDTO>();
	
	{
		DepartmentDTO dept = new DepartmentDTO(0, "SCIENCE");
		dtos.add(dept );
	}

	@GetMapping("/all")
	public List<DepartmentDTO> getDepartments() {
		
		return dtos;
	}
}
