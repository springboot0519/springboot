package com.conferencedemo.controller;

import java.util.List;

import com.conferencedemo.dao.EmployeeDAO;
import com.conferencedemo.model.Employee;
import com.conferencedemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {

	@Autowired
	private EmployeeDAO employeeDAO;

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to RestTemplate Demo.";
	}

	// URL - http://localhost:8080/employees
	@RequestMapping(value = "/employees", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
	}

	// URL - http://localhost:8080/employee/{empNo}
	@RequestMapping(value = "/employee/{empNo}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee getEmployee(@PathVariable("empNo") String empNo) {
		return employeeDAO.getEmployee(empNo);
	}
	
	// URL - POST http://localhost:8080/employee}
	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee addEmployee(@ModelAttribute Employee employee) {
		return employeeDAO.addEmployee(employee);
	}
	
	// URL - PUT http://localhost:8080/employee}
	@RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee updateEmployee(@ModelAttribute Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}
	
	// URL - DELETE http://localhost:8080/employee/{empNo}
	@RequestMapping(value = "/employee/{empNo}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable("empNo") String empNo) {
		employeeDAO.deleteEmployee(empNo);
	}

	
	@Autowired
	private EmployeeService employeeService;
	
	// URL - http://localhost:8080/mongoemployees
	@RequestMapping(value = "/mongoemployees", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Employee> getMongoEmployees() {
		List<Employee> list = employeeService.findAll();
		return list;
	}

	// URL - http://localhost:8080/mongoemployee/{empNo}
	@RequestMapping(value = "/mongoemployee/{empNo}", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee getMongoEmployee(@PathVariable("empNo") String empNo) {
		return employeeService.findById(empNo);
	}
	
	// URL - POST http://localhost:8080/mongoemployee}
	@RequestMapping(value = "/mongoemployee", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee addMongoEmployee(@ModelAttribute Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	// URL - PUT http://localhost:8080/mongoemployee}
	@RequestMapping(value = "/mongoemployee", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee updateMongoEmployee(@ModelAttribute Employee employee) {
		return employeeService.updateEmployee(employee);
	}
	
	// URL - DELETE http://localhost:8080/mongoemployee/{empNo}
	@RequestMapping(value = "/mongoemployee/{empNo}", method = RequestMethod.DELETE)
	public void deleteMongoEmployee(@PathVariable("empNo") String empNo) {
		employeeService.deleteEmployee(empNo);
	}
	
}