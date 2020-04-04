package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.EmployeeDao;
import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee createEmployee(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public List<Employee> listEmployee() {
		dao.findAll();
		return dao.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> findById = dao.findById(employee.getEno());
		if (findById.isPresent()) {
			Employee updateEmployee = findById.get();
			updateEmployee.setEno(employee.getEno());
			updateEmployee.setName(employee.getName());
			updateEmployee.setSalary(employee.getSalary());
			dao.save(updateEmployee);
			return updateEmployee;
		} else if (Optional.empty() != null) {
			return dao.save(employee);
		} else {
			throw new ResourceNotFoundException("no employee found this employee eno :" + employee.getEno());
		}

	}

	@Override
	public void deleteEmployee(Integer eno) {
		Optional<Employee> findById = dao.findById(eno);

		if (findById.isPresent()) {
			dao.delete(findById.get());
		} else {
			throw new ResourceNotFoundException("no employee found this employee eno :" + eno);
		}

	}

	@Override
	public Employee searchById(Integer eno) {

		Optional<Employee> findById = dao.findById(eno);

		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new ResourceNotFoundException("no employee found this employee eno :" + eno);
		}
	}

}
