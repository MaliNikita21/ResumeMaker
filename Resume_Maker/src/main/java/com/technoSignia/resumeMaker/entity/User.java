package com.technoSignia.resumeMaker.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	UUID id;
	
	String name;
	
	Long contact;
	
	String email;
	
    String password;
	
	@CreationTimestamp
    LocalDateTime createdOn;
	
	@UpdateTimestamp
	LocalDateTime updatedOn;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", password="
				+ password + ",]";
	}

	public User(UUID id, String name, Long contact, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
