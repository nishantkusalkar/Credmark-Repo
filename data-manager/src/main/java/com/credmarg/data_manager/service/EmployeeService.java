package com.credmarg.data_manager.service;

import java.time.LocalTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.credmarg.data_manager.dao.Employee;
import com.credmarg.data_manager.repository.EmployeeRepository;

@Service
public class EmployeeService {
	

	final Logger logger = LogManager.getLogger(EmployeeService.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> save(Employee employee) {
    	final Logger logger = LogManager.getLogger(EmployeeService.class);
    	
    	employee.setCreated_on(LocalTime. now().toString());
    	
    	if(employee.getRole().equalsIgnoreCase("ADMIN")) {
    		employee.setRole("1");
    	}else {
    		employee.setRole("0");
    	}
    	logger.info("Received request to create employee: {}", employee.toString());
    	
    	Employee createdEmployee = employeeRepository.save(employee);
    	logger.info("Created employee: {}", createdEmployee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.OK);
    }

    public List<Employee> getAll(String createdBy) {
    	logger.error("Received request to get Employee with created By :: {}", createdBy);
        return employeeRepository.findByCreatedBy(createdBy);
    }
}
