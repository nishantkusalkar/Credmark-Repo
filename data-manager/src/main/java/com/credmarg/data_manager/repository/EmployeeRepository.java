package com.credmarg.data_manager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.data_manager.dao.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByName(String name);
	
	Employee findByEmail(String email);
	
	List<Employee> findByCreatedBy(String created_by);	
	
}
