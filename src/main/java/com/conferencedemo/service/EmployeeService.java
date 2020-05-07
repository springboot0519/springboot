package com.conferencedemo.service;

import java.util.List;

import com.conferencedemo.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(String empNo);
	
	Employee addEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployee(String empNo);
}
