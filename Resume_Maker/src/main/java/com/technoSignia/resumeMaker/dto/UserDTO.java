package com.technoSignia.resumeMaker.dto;

import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDTO {

	UUID id;

	@NotEmpty(message = "Name should not be empty")
	@Pattern(regexp = "^[A-Za-z]+(\\s[A-Za-z]+)*$", message = "Invalid name format")
	// @Pattern(regexp = "^[A-Za-z]+([A-Za-z\\s]*[A-Za-z])?\\s*$", message =
	// "Invalid name format")
	private String name;

	@NotNull(message = "Contact is required")
	@Min(value = 1000000000, message = "Phone number must be at least 10 digits")
	@Max(value = 9999999999L, message = "Phone number must be at most 10 digits")
	private Long contact;

	@Email(message = "Email should not be empty")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Invalid email address")
	private String email;

	@NotEmpty(message = "Password should not be empty")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be at least 8 characters long and has atleast one uppercase,one lowercase,one digit, and one special character.")
	private String password;

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
		return "UserDTO [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", password="
				+ password + "]";
	}

	public UserDTO(UUID id, @NotEmpty(message = "Name should not be empty") String name,
			@NotNull(message = "Contact is required") Long contact,
			@Email(message = "Email should not be empty") String email,
			@NotEmpty(message = "Password should not be empty") String password) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
