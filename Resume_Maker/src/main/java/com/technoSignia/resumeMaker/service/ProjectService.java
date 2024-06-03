package com.technoSignia.resumeMaker.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.technoSignia.resumeMaker.dao.ProjectDao;
import com.technoSignia.resumeMaker.dto.ProjectDTO;
import com.technoSignia.resumeMaker.entity.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	public Project addProjectDetails(ProjectDTO projectDTO) {
		
		Project project=new Project (
				projectDTO.getProjectId(),	
				projectDTO.getTitle(),
				projectDTO.getTechStack(),
				projectDTO.getRole(),
				projectDTO.getDescription()
				);
		return projectDao.save(project) ;	
	}

	public Project findProjectById(UUID id) {
		return projectDao.findById(id).get();
	}

	public List<Project> findAllProjectDetails() {
		return projectDao.findAll();
	}

	public Project updateProjectDetailsById(Project project, UUID id) {
		 
		Project dbProject=null;
		Optional<Project> OptinalPro=projectDao.findById(id);
		if (OptinalPro.isPresent()){
			dbProject=OptinalPro.get();
			 if(project.getTitle()!=null) {
				 dbProject.setTitle(project.getTitle());
			 }
			 
			 if(project.getTechStack()!=null) {
				 dbProject.setTechStack(project.getTechStack());
			 }
			 
			 if(project.getRole()!=null) {
				 dbProject.setRole(project.getRole());
			 }
                
			if(project.getDescription()!=null) {
				dbProject.setDescription(project.getDescription());
			}
		}
		return projectDao.save(dbProject);
	}

	public String deleteProjectDetailsById(UUID id) {
		
		 Optional<Project> OptinalPro =projectDao.findById(id);
			 if(OptinalPro.isPresent()) {
				 projectDao.deleteById(id);
				 return "Project record delete successfully.";
			 }
			 else {
				 return "Project record not found;";
			 }
	}

}
