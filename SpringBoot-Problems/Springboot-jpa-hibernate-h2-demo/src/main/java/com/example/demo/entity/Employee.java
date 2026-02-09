package com.example.demo.entity;

import jakarta. persistence. Entity;
import jakarta.persistence.Id;
import jakarta.persistence. Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	private int id;
	private String name;
	private int salary;
	
	public Employee() {

	}
	
	public Employee(int id ,String name, int salary) {
		this.id=id;
		this.name=name;
		this. salary=salary;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Id : " + id + ", Name = " + name + ", salary = "+ salary;
	}
}




