package com.javacoder.departmentservice.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacoder.departmentservice.entity.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Long>{

	Department findByDepId(Long depId);

}
