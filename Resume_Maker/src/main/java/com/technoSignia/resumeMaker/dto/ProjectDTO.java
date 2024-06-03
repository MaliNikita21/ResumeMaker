package com.technoSignia.resumeMaker.dto;

import java.util.UUID;

public class ProjectDTO {
    
	UUID projectId;
    
	//PersonalDetails pId;
	
	String title;
	
	String techStack;
	
	String role;
	
	String description;

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
		return "ProjectDTO [projectId=" + projectId + ", title=" + title + ", techStack=" + techStack + ", role=" + role
				+ ", description=" + description + "]";
	}

	public ProjectDTO(UUID projectId, String title, String techStack, String role, String description) {
		super();
		this.projectId = projectId;
		this.title = title;
		this.techStack = techStack;
		this.role = role;
		this.description = description;
	}

	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
