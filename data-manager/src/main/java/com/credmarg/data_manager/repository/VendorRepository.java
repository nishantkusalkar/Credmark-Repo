package com.credmarg.data_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.data_manager.dao.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
	
}