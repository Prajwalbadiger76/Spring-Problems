package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private final EmployeeDao employeeDao;

	public EmployeeController(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@GetMapping("/employees")
 public List<Employee> getEmployees()
	{ 
		return employeeDao. getallEmployees () ;
   }
	
	@GetMapping("/employees/{id}")
	 public Employee getEmployee(@PathVariable int id) 
		{ 
			return employeeDao.getEmployeeById(id) ;
	   }
	
	
	
	@GetMapping("/employee")
		public String addemployee(@RequestBody Employee emp)
		{
			System.out.println("Post mehtod Received from Request Body");
			System.out.println(emp.getId() +" - "+ emp.getName() + " -"  + emp.getSalary());
			employeeDao.addEmployee(emp);
			return "Employee Added Sucessfully";
			
			
			
		}
	}