package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {

	public Employee createEmployee(Employee employee);
	public List<Employee> listEmployee();
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Integer eno);
	public Employee searchById(Integer eno);

}
