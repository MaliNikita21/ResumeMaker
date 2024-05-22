package com.technoSignia.resumeMaker.dto;

public class UserDTO {

	long id;

	String name;

	long contact_No;

	String email_Id;
	
	String password;
	
	String confirm_Password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact_No() {
		return contact_No;
	}

	public void setContact_No(long contact_No) {
		this.contact_No = contact_No;
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

	public String getConfirm_Password() {
		return confirm_Password;
	}

	public void setConfirm_Password(String confirm_Password) {
		this.confirm_Password = confirm_Password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", contact_No=" + contact_No + ", email_Id=" + email_Id
				+ ", password=" + password + ", confirm_Password=" + confirm_Password + "]";
	}

	public UserDTO(long id, String name, long contact_No, String email_Id, String password, String confirm_Password) {
		super();
		this.id = id;
		this.name = name;
		this.contact_No = contact_No;
		this.email_Id = email_Id;
		this.password = password;
		this.confirm_Password = confirm_Password;
	}

	public UserDTO() {
		super();
	}

	
}
