package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.NamedJdbcTemplate;

import org.springframework.stereotype. Repository;

@Repository
public class EmployeeDao {
	private final JdbcTemplate jdbcTemplate;
	private final NamedJdbcTemplate namedJdbcTemplate;
	
	public EmployeeDao (JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		
	}
	
	public List<Employee> getallEmployees() {
		String sql = "Select* from Employee";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
		
	}
	
	public List<Employee> getEmployeeById() {
		String sql = "Select* from Employee where id = :id";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
		
	}
	
	public Employee getEmployeeById(int id) {
		String sql = "Select* from Employee where id=id";
		return jdbcTemplate.queryForObject(sql,Map.of("id",id), new EmployeeRowMapper()); 
	}
	
	public int addEmployee(Employee emp)
	{
		String sql=" insert into Employee(id,name,salary) values(:id,:name,:salary)";	
		return namedJdbcTemplate.update(sql,new BeanPropertySqlParameterSource(emp));
				
	}
	
}

