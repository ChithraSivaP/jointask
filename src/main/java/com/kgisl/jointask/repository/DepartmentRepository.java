package com.kgisl.jointask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kgisl.jointask.dto.DeptEmpDto;
import com.kgisl.jointask.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("SELECT new com.kgisl.jointask.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d LEFT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataLeftJoin();

	@Query("SELECT new com.kgisl.jointask.dto.DeptEmpDto(d.name, e.name, e.email, e.address) "
			+ "FROM Department d RIGHT JOIN d.employees e")
	List<DeptEmpDto> fetchEmpDeptDataRightJoin();

}