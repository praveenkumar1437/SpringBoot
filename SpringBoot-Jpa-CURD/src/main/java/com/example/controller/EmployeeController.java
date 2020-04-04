package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok().body(employeeService.listEmployee());

	}

	@GetMapping("/employees/{eno}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer eno) {
		return ResponseEntity.ok().body(employeeService.searchById(eno));

	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok().body(employeeService.createEmployee(employee));

	}

	@PutMapping("/employees/{eno}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer eno, @RequestBody Employee employee) {
		employee.setEno(eno);
		return ResponseEntity.ok().body(employeeService.updateEmployee(employee));

	}

	@DeleteMapping("/employees/{eno}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer eno) {
		employeeService.deleteEmployee(eno);
		return ResponseEntity.ok("employee number "+eno+" is deleted from the DataBase");

	}

}
