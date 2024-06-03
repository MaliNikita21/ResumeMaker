package com.technoSignia.resumeMaker.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.technoSignia.resumeMaker.dao.PersonalDetailsDao;
import com.technoSignia.resumeMaker.entity.PersonalDetails;
import com.technoSignia.resumeMaker.exceptions.PersonalDetailsNotFoundException;

@Service
public class PersonalDetailsService {
     
	@Autowired
	PersonalDetailsDao personalDetailsDao;
	
	public PersonalDetails savePersonalDetails(PersonalDetails personalDetails) {
		
		return personalDetailsDao.save(personalDetails);
		
	}
    
	@Cacheable(value="Personaldetails", key="#pId")
	public ResponseEntity<?> findPersonalById(Long pId) {
		Optional<PersonalDetails> opPersonalDetails= personalDetailsDao.findById(pId);
		if(opPersonalDetails.isPresent()) {
			 return new ResponseEntity<PersonalDetails>(opPersonalDetails.get(), HttpStatus.OK);	
		}
		else {
			throw new PersonalDetailsNotFoundException("personal details not found for given id while finding person"+pId);
		}
		
	}       //changes made in find by id for exception handling

	public List<PersonalDetails> findAllPersonal() {
		
		return personalDetailsDao.findAll();
	}

	public ResponseEntity<?> deletePersonalById(Long pId) {
		
	Optional<PersonalDetails> opPerson= personalDetailsDao.findById(pId);
		if(opPerson.isPresent()) {
			personalDetailsDao.deleteById(pId);
			return new ResponseEntity<>("Record deleted successfully",HttpStatus.OK);
		}
		else {
			
			throw new PersonalDetailsNotFoundException("personal details not found for given id while deleting"+pId);
		}
		  	
	}       //changes made in delete by id for exception handling
	
	

	public PersonalDetails updatePersonalById(Long pId, PersonalDetails personalDetails) {
		PersonalDetails  dbPer=null;
		Optional<PersonalDetails> opPer=personalDetailsDao.findById(pId);
		  
		if(opPer.isPresent()) {
			
			dbPer=opPer.get();
			dbPer.setFirstName(personalDetails.getFirstName());
			dbPer.setLastName(personalDetails.getLastName());
			dbPer.setMiddleName(personalDetails.getMiddleName());
			dbPer.setEmailId(personalDetails.getEmailId());
			dbPer.setContact(personalDetails.getContact());
			dbPer.setAddress(personalDetails.getAddress());
			dbPer.setCity(personalDetails.getCity());
			dbPer.setState(personalDetails.getState());
			dbPer.setPinCode(personalDetails.getPinCode());
			dbPer.setGender(personalDetails.getGender());
			
			return personalDetailsDao.save(dbPer);
		}
		
		return dbPer;
	}
	
}