package com.stackroute.deploymentdashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.domains.*;
import com.stackroute.deploymentdashboard.repository.*;

/*
 * Service for CRUD operations on PROJECT
 * 
 * */

@Service
public class ProjectManagementServiceImpl {
	
	@Autowired
	private ProjectManagementCRUDRepository projectrepository;


	
	
	public ProjectManagementCRUDRepository getProjectrepository() {
		return projectrepository;
	}

	public void setProjectrepository(ProjectManagementCRUDRepository projectrepository) {
		this.projectrepository = projectrepository;
	}

	
	/*
	 * Method for adding a Project
	 * */
	public ProjectManagementObject add(ProjectManagementObject projectManagementObject) {
		
		projectrepository.save(projectManagementObject);
		return projectManagementObject;
	}
	
	
	
	/*
	 * Method for getting  a Project by Id
	 * */
	public ProjectManagementObject getByid(String id){
		
		ProjectManagementObject projectManagementObject =projectrepository.findOne(id);
		return projectManagementObject;
		
	}
	

	/*
	 * Method for updating  a Project
	 * */
	
	public ProjectManagementObject updateProject(ProjectManagementObject projectManagementObject) {
		projectrepository.save(projectManagementObject);
		return projectManagementObject;
	}
	/*
	 * Method for deleting a Project
	 * */
	public void deleteProject(String id) {
		projectrepository.delete(id);
	}
	/*
	 * Method for listing  a Project
	 * */
	public List<ProjectManagementObject> getAll(){
		List<ProjectManagementObject> projectManagementObject=new ArrayList<>();
		projectrepository.findAll().forEach(projectManagementObject::add);
		return projectManagementObject;
	}

}
