package com.technoSignia.resumeMaker.dto;

public class LoginDTO {

	String email_Id;
	String password;
	
	public LoginDTO(String email_Id, String password) {
		super();
		this.email_Id = email_Id;
		this.password = password;
	}

	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [email_Id=" + email_Id + ", password=" + password + "]";
	}
	
	
	
}
