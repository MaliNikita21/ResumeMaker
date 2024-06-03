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

import com.technoSignia.resumeMaker.entity.PersonalDetails;
import com.technoSignia.resumeMaker.service.PersonalDetailsService;

import jakarta.validation.Valid;

@RestController
public class PersonalDetailsController {
	@Autowired
	PersonalDetailsService personalDetailsService;

   @PostMapping("/savepersonal")	
    public ResponseEntity<?>createPersonalDetails(@Valid @RequestBody PersonalDetails personalDetails,BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			List<String> errors = bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage())
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		PersonalDetails createPersonalDetails=personalDetailsService.savePersonalDetails(personalDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(createPersonalDetails);
	}
   
//   @PostMapping("/owner")
//	public ResponseEntity<Object> createOwnerDetails( @Valid @RequestBody Owner owner, BindingResult bindingResult) {
//		
//		if(bindingResult.hasErrors()) {
//			
//			List<String> errors = bindingResult.getAllErrors().stream().map(error -> error.getDefaultMessage())
//					.collect(Collectors.toList());
//			return ResponseEntity.badRequest().body(errors);
//		}
//		Owner createOwnerDetails= ownerService.createOwnerDetails(owner);
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(createOwnerDetails);
//	}
   @GetMapping("/findById/{pId}")
   public ResponseEntity<?> findPersonalDetailsById(@PathVariable Long pId) {
	   
	   return personalDetailsService.findPersonalById(pId);
	      
   }     //  changes exception
   
   @GetMapping("/findAll")
   public List<PersonalDetails> FindAllpersonalDetails(){
   
  return personalDetailsService.findAllPersonal();
}
   
   @DeleteMapping("/deletePersonalDetailsById/{pId}")
   public ResponseEntity<?> deletePersonalDetailsById(@PathVariable Long pId){
	   
	   return personalDetailsService.deletePersonalById(pId);  //changes exception
	   
   }
   
   @PutMapping("/updatePersonalDetails/{pId}")
   public PersonalDetails updatePersonalDetailsById(@PathVariable Long pId, @RequestBody PersonalDetails personalDetails) {
	   
	   return personalDetailsService.updatePersonalById(pId,personalDetails);
	   
   }      
   

   
}