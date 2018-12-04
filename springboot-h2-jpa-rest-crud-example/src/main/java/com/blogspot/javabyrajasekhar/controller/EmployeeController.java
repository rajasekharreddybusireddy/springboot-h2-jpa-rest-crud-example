package com.blogspot.javabyrajasekhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogspot.javabyrajasekhar.model.Employee;
import com.blogspot.javabyrajasekhar.repository.EmployeeRepository;

@RestController
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/allemployees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();

	}
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable(name="id") Integer id) {
		return employeeRepository.getOne(id);
		
	}
	@PostMapping("/save")
	public List<Employee> saveEmployee(@RequestBody Employee employee) {
		
		employeeRepository.save(employee);
		return employeeRepository.findAll();

	}
	
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteById(@PathVariable Integer id) {
		
		employeeRepository.deleteById(id);
		return employeeRepository.findAll();

	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
		
	}
}
