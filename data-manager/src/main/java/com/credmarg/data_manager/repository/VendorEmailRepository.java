package com.credmarg.data_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.data_manager.dao.VendorEmailLog;

@Repository
public interface VendorEmailRepository extends JpaRepository<VendorEmailLog, Long> {
	
	List<VendorEmailLog> findByCreatedBy(String created_by);
	
}