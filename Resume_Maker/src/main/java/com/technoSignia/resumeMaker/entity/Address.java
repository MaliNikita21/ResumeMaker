package com.technoSignia.resumeMaker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@Column(name="id",length=45)
	Long id;
	
    String street;
	
    String city;
    
    String state;
    
    String country;
    
	Long pincode;
	
}