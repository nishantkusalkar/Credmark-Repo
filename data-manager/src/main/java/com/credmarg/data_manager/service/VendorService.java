package com.credmarg.data_manager.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.credmarg.data_manager.dao.Vendor;
import com.credmarg.data_manager.repository.VendorRepository;

@Service
public class VendorService {
	
	final Logger logger = LogManager.getLogger(VendorService.class);
	
    @Autowired
    private VendorRepository vendorRepository;

    public ResponseEntity<Vendor> save(Vendor vendor){
    	logger.info("Received request to create vendor :: {}", vendor.toString());
        return new ResponseEntity<>(vendorRepository.save(vendor), HttpStatus.OK);
    }

    public List<Vendor> getAll() {
    	
    	logger.info("Received request to fetch all vendors :: {}");
        return vendorRepository.findAll();
    }
}
