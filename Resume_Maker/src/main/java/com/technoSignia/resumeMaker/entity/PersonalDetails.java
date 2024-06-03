package com.technoSignia.resumeMaker.entity;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class PersonalDetails {

@Id
Long pId;
@NotEmpty(message="first name should not be empty ")
private String firstName;
@NotEmpty(message="last name should not be empty")
private String lastName;

@NotEmpty(message="middle name should not be empty")
private String middleName;
@Email(message="email address is not valid")
private String emailId;

@NotNull
private Long contact;
@NotEmpty(message="address should not be empty")
private String address;
@NotEmpty(message="city should not be empty")
private String city;
@NotEmpty(message="state should not be empty")
private String state;

private Long pinCode;
@NotEmpty(message="gender should not be empty")
private String gender;

@CreationTimestamp
private LocalDateTime createdOn;

@UpdateTimestamp
private LocalDateTime updatedOn;

public Long getpId() {
	return pId;
}

public void setpId(Long pId) {
	this.pId = pId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public Long getContact() {
	return contact;
}

public void setContact(Long contact) {
	this.contact = contact;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public Long getPinCode() {
	return pinCode;
}

public void setPinCode(Long pinCode) {
	this.pinCode = pinCode;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public LocalDateTime getCreatedOn() {
	return createdOn;
}

public void setCreatedOn(LocalDateTime createdOn) {
	this.createdOn = createdOn;
}

public LocalDateTime getUpdatedOn() {
	return updatedOn;
}

public void setUpdatedOn(LocalDateTime updatedOn) {
	this.updatedOn = updatedOn;
}



public PersonalDetails(Long pId, String firstName, String lastName, String middleName, String emailId, Long contact,
		String address, String city, String state, Long pinCode, String gender, LocalDateTime createdOn,
		LocalDateTime updatedOn) {
	super();
	this.pId = pId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.middleName = middleName;
	this.emailId = emailId;
	this.contact = contact;
	this.address = address;
	this.city = city;
	this.state = state;
	this.pinCode = pinCode;
	this.gender = gender;
	this.createdOn = createdOn;
	this.updatedOn = updatedOn;
}

public PersonalDetails() {
	super();
	// TODO Auto-generated constructor stub
}

}
