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
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	UUID projectId;
    
	//PersonalDetails pId;
	
	String title;
	
	String techStack;
	
	String role;
	
	String description;
		
	@CreationTimestamp
    LocalDateTime createdOn;
	
	@UpdateTimestamp
	LocalDateTime updatedOn;

	public UUID getProjectId() {
		return projectId;
	}

	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title + ", techStack=" + techStack + ", role=" + role
				+ ", description=" + description + "]";
	}

	public Project(UUID projectId, String title, String techStack, String role, String description) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.techStack = techStack;
		this.role = role;
		this.description = description;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
