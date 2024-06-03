package com.technoSignia.resumeMaker.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class Employment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@NotEmpty(message = "job role is required")
	String jobRole;
	
	@NotEmpty(message = "company name is required")
	String companyName;
	
	@NotNull(message = "start date is required")
	LocalDate startDate;
	
	
	LocalDate endDate;
	
	@NotEmpty(message = "city is required")
	String city;
	
	@NotEmpty(message = "country is required")
	String country;
	
	@OneToOne
	PersonalDetails  personalDetails;
	
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@UpdateTimestamp
	 private LocalDateTime updatedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "Employment [id=" + id + ", jobRole=" + jobRole + ", companyName=" + companyName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", city=" + city + ", country=" + country + "]";
	}

	
	
	
	
}
