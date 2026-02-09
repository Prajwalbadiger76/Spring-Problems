package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	@GetMapping
	public List<Employee> getemployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/{id}")
	public Employee GetEmployeebyId(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee adddEmployee(@RequestBody Employee emp) {
		return employeeService.saveEmployee(emp);
	}
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable int id,@RequestBody Employee updatedeEmp ) {
		return employeeService.updateEmployee(id, updatedeEmp);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
}
