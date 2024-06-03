package com.technoSignia.resumeMaker.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.technoSignia.resumeMaker.dto.ProjectDTO;
import com.technoSignia.resumeMaker.entity.Project;
import com.technoSignia.resumeMaker.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	
	@PostMapping(path = "/project")
	public Project saveProjectDetails(@RequestBody ProjectDTO projectDTO) {
		return projectService.addProjectDetails(projectDTO);
		
	}
	
	@GetMapping(path ="/project")
	public List<Project> findAllProjectDetails(){
		return projectService.findAllProjectDetails();
		
	}
	
	
	@GetMapping( "/project/{id}")
	public Project findProjectDetails(@PathVariable UUID id) {
		return projectService.findProjectById(id);
		
	}
	
	@PutMapping(path ="/projectUpdate{id}" )
	public Project updateProjectDetailsById(@RequestBody Project project,@RequestParam UUID id) {
		return projectService.updateProjectDetailsById(project,id);
		
	}
	
	@DeleteMapping(path = "/project{id}")
	public String deleteProjectDetailsById(@RequestParam UUID id ) {
		return projectService.deleteProjectDetailsById(id);
		
	}

}
