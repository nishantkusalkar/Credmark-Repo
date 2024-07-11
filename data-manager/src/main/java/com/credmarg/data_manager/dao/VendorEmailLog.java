package com.credmarg.data_manager.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vendor_email_log")
public class VendorEmailLog {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
       
    @Column(name = "message")
    private String message;
    
    @Column(name = "vendor_id")
    private int vendor_id;
    
    @Column(name = "vendor_email")
    private String vendor_email;
    
    @Column(name = "createdBy")
    private String createdBy;
    
    @Column(name = "createdOn")
    private String createdOn;

}
