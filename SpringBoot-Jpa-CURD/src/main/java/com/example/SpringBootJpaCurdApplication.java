package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Employee;

@SpringBootApplication
public class SpringBootJpaCurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaCurdApplication.class, args);
		
		Employee employee = new Employee();
		employee.setEno(12);
		employee.setName("praveen");
		employee.setSalary(232322.121);
	}

}
