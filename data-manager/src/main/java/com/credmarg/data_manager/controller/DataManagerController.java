package com.credmarg.data_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.data_manager.dao.Employee;
import com.credmarg.data_manager.dao.Vendor;
import com.credmarg.data_manager.dao.VendorEmailLog;
import com.credmarg.data_manager.repository.EmployeeRepository;
import com.credmarg.data_manager.service.EmailService;
import com.credmarg.data_manager.service.EmployeeService;
import com.credmarg.data_manager.service.VendorService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DataManagerController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Employee loginRequest) {
		Employee employee = employeeRepository.findByEmail(loginRequest.getEmail());
		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.status(401).body("Invalid credentials");
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(@RequestParam String userId) {
		return employeeService.getAll(userId);
	}

	@PostMapping("/vendors")
	public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
		return vendorService.save(vendor);
	}

	@GetMapping("/vendors")
	public List<Vendor> getAllVendors() {
		return vendorService.getAll();
	}

	@GetMapping("/email-logs")
	public List<VendorEmailLog> getAllEmailLogs() {
		return emailService.getAll();
	}

	@PostMapping("/send-email")
	public String sendEmailPost(@RequestBody VendorEmailLog request) {
		emailService.sendEmail(request);
		return "Email sent successfully!";
	}
}
