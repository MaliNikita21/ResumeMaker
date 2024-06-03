package com.technoSignia.resumeMaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.technoSignia.resumeMaker.Exception.EmploymentNotFoundException;
import com.technoSignia.resumeMaker.dao.EmploymentDao;
import com.technoSignia.resumeMaker.entity.Employment;

@Service
public class EmploymentService {
	
	@Autowired
	EmploymentDao employmentDao;
	
	public Employment saveEmploymentDetails(Employment employment) {
		
		return employmentDao.save(employment);
		
	}
	
	
	public  List<Employment> findAllEmploymentDetails(){
		
		return employmentDao.findAll();
	}


	@Cacheable(value="employments",key="#id")
	public ResponseEntity<?> findEmploymentDetailsById(Long id) {
		
		System.out.println("fetched data from database");
		Optional<Employment> optionalObj = employmentDao.findById(id);
		
		if(optionalObj.isPresent()) {
			
			return  new ResponseEntity<Employment>(optionalObj.get(),HttpStatus.OK);
		}
		else {
			throw new EmploymentNotFoundException("Emoployment Details Not Found For Given id : "+id);
			
		}
	}
	
	public Employment updateEmploymentDetailsById(Employment employment, Long id) {
		
		Optional<Employment> optionalObj = employmentDao.findById(id);
		
		Employment dbEmployment = null;
		
		if(optionalObj.isPresent()) {
			
			dbEmployment = optionalObj.get();
			
			if(employment.getJobRole()!=null) {
				
			dbEmployment.setJobRole(employment.getJobRole());
			}
			if(employment.getCompanyName()!=null) {
				
			dbEmployment.setCompanyName(employment.getCompanyName());
			}
			if(employment.getStartDate()!=null) {
				
			dbEmployment.setStartDate(employment.getStartDate());
			}
			if(employment.getEndDate()!=null) {
				
			dbEmployment.setEndDate(employment.getEndDate());
			}
			if(employment.getCity()!=null) {
				
			dbEmployment.setCity(employment.getCity());
			}
			if(employment.getCountry()!=null) {
				
			dbEmployment.setCountry(employment.getCountry());
			}
		}
		return employmentDao.save(dbEmployment);
	}
	
	public ResponseEntity<?> deleteEmploymentDetailsById(Long id) {
		
		Optional<Employment> optionalObj = employmentDao.findById(id);
		
		if(optionalObj.isPresent()) {
			
			employmentDao.deleteById(id);
			
			return new ResponseEntity<>("Record Deleted Successfully",HttpStatus.OK);
		}
		else {
			
			throw new EmploymentNotFoundException("Emoployment Record Not Found For Given id : "+id);
			
		}
		
	}
	
	
	
	 


}
