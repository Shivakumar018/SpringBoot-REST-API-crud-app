package com.REST_API.rset_api.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.REST_API.rset_api.DTO.ResponseDto;
import com.REST_API.rset_api.Entity.Employee;
import com.REST_API.rset_api.ExceptionHandler.DataExistsException;
import com.REST_API.rset_api.ExceptionHandler.DataNotFoundException;
import com.REST_API.rset_api.Reposetory.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

	EmployeeRepository repository;
	
	//to save employee record 
	public ResponseDto save(@RequestBody Employee employee) {
		if (repository.existsByNumberOrEmail(employee.getNumber(), employee.getEmail()))
			throw new DataExistsException("Email or Mobile Already Exists");
		repository.save(employee);
		return new ResponseDto("Data Added success", employee);
	}

	public ResponseDto featchAll() {
		List<Employee> employees = repository.findAll();
		if (employees.isEmpty())
			throw new DataNotFoundException("Data already exists");
		else
			return new ResponseDto("Data found", employees);
	}


	public ResponseDto fetchById(Integer id) {
		Employee employee = repository.findById(id).orElseThrow(() -> new DataNotFoundException("Data Not Found with Id " + id));
		return new ResponseDto("Data Found", employee);
	}

	public ResponseDto featchByDepartment(String dept) {
		List<Employee> employees = repository.findByDepartment(dept);
		return new ResponseDto("Data Found", employees);
	}

	public ResponseDto featchByEmail(String email) {
		List<Employee> employees = repository.findByEmail(email);
		return new ResponseDto("Data Found", employees);
	}

	public void delete(@PathVariable int id) {
		repository.findById(id).orElseThrow(() -> new DataNotFoundException("Data Not Found with Id " + id));
		repository.deleteById(id);	
	}
	
	public ResponseDto updateCompletly(int id, Employee employee) {
		repository.findById(id).orElseThrow(() -> new DataNotFoundException("Data Not Found with Id " + id));
		employee.setId(id);
		repository.save(employee);
		return new ResponseDto("data updated sucessfully", employee);
	}
	
	public ResponseDto updatePatially(int id, Employee employee) {
		Employee exEmployee=repository.findById(id).orElseThrow(() -> new DataNotFoundException("Data Not Found with Id " + id));
		employee.setEmail(employee.getEmail()==null?employee.getEmail():employee.getEmail());
		employee.setNumber(employee.getNumber()==null?employee.getNumber():employee.getNumber());
		employee.setDepartment(employee.getDepartment()==null?employee.getDepartment():employee.getDepartment());
		repository.save(employee);
		return new ResponseDto("data updated sucessfully", employee);
	}
}