package com.Project.Management.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Management.domains.*;
import com.Project.Management.repository.*;

/*
 * Service for CRUD operations on PROJECT
 * 
 * */

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectrepository;


	
	
	public ProjectRepository getProjectrepository() {
		return projectrepository;
	}

	public void setProjectrepository(ProjectRepository projectrepository) {
		this.projectrepository = projectrepository;
	}

	
	/*
	 * Method for adding a Project
	 * */
	public Project add(Project project) {
		
		projectrepository.save(project);
		return project;
	}
	
	
	
	/*
	 * Method for getting  a Project by Id
	 * */
	public Project getByid(String id){
		
		Project project =projectrepository.findOne(id);
		return project;
		
	}
	

	/*
	 * Method for updating  a Project
	 * */
	
	public Project updateProject(Project project) {
		projectrepository.save(project);
		return project;
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
	public List<Project> getAll(){
		List<Project> project=new ArrayList<>();
		projectrepository.findAll().forEach(project::add);
		return project;
	}

}
