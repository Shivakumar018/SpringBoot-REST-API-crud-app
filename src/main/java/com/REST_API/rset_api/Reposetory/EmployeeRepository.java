package com.REST_API.rset_api.Reposetory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.REST_API.rset_api.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	boolean existsByNumberOrEmail(Long number, String email);

	List<Employee> findByDepartment(String department);

	List<Employee> findByEmail(String email);

}
