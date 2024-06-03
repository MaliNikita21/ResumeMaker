package com.technoSignia.resumeMaker.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.technoSignia.resumeMaker.entity.Employment;
import com.technoSignia.resumeMaker.service.EmploymentService;

import jakarta.validation.Valid;

@RestController
public class EmploymentController {
	
	@Autowired
	EmploymentService employmentService;
	
	@PostMapping(path = "/employment")
	public ResponseEntity<Object> saveEmploymentDetails( @Valid @RequestBody Employment employment, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			
			List<String> errors =  bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());
			
			return ResponseEntity.badRequest().body(errors);
		}
		Employment saveEmploymentDetails = employmentService.saveEmploymentDetails(employment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveEmploymentDetails);
		
	}
	
	@GetMapping(path ="/employment")
	public List<Employment> findAllEmploymentDetails(){
		return employmentService.findAllEmploymentDetails();
	}
	
	@GetMapping("/employment/{id}")
	public ResponseEntity<?> findEmploymentDetailsById(@PathVariable Long id) {
	     
		return employmentService.findEmploymentDetailsById(id);
	}
	
	@PutMapping("/employment/{id}")
	public Employment updateEmploymentDetailsById(@RequestBody Employment employment ,@PathVariable Long id ) {
		System.out.println("data extracted."+employment);
		return employmentService.updateEmploymentDetailsById(employment, id);
	}
	
	@DeleteMapping("employment/{id}")
	public ResponseEntity<?> deleteEmploymentDetailsById(@PathVariable Long id) {
		
		return employmentService.deleteEmploymentDetailsById(id);
	}
	

	
}
