package com.REST_API.rset_api.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.REST_API.rset_api.DTO.ResponseDto;
import com.REST_API.rset_api.Entity.Employee;
import com.REST_API.rset_api.Service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
///api/v1 = "Root path for version 1 of your REST API"It’s used for API versioning, organization, and maintainability.
@AllArgsConstructor
public class employeeController {

	EmployeeService service;

	@PostMapping("/employee")
	@ResponseStatus(value = HttpStatus.CREATED)
	@Operation(summary = "Add employee")
	public ResponseDto save(@RequestBody Employee employee) {
		return service.save(employee);
	}

	@GetMapping("/employee")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch All Record")
	public ResponseDto featchAll() {
		return service.featchAll();
	}

	@GetMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch Record by Id")
	public ResponseDto featchById(@PathVariable Integer id) {
		return service.fetchById(id);
	}

	@GetMapping("/employee/depeatment/{Department}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch Record by department")
	public ResponseDto featchById(@PathVariable String Department) {
		return service.featchByDepartment(Department);
	}

	@GetMapping("/employee/email/{Email}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "Fetch Record by Email")
	public ResponseDto featchByEmail(@PathVariable String Email) {
		return service.featchByEmail(Email);
	}
	
	@DeleteMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@Operation(summary = "Delete Record")
	public void delete(@PathVariable int id) {
		 service.delete(id);
	}
	
	@PutMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "updated Record")
	public ResponseDto updateCompletly(@PathVariable int id, @RequestBody Employee employee) {
		 return service.updateCompletly(id, employee);
	}
	
	@PatchMapping("/employee/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "updated Record")
	public ResponseDto updatePatially(@PathVariable int id, @RequestBody Employee employee) {
		 return service.updatePatially(id, employee);
	}
}