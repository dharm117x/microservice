package com.dksite.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.dksite.FiegnClientConfiguration;
import com.dksite.data.DepartmentDTO;

@FeignClient(name = "DEPARTMENT-SERVICE", configuration = FiegnClientConfiguration.class)
public interface DepartmentClient {
	
	@GetMapping("/departments/all")
	public List<DepartmentDTO> getDepartments();
}
