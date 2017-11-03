package com.stackroute.deploymentdashboard.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.Exceptions.ProjectAlreadyExistsException;
import com.stackroute.deploymentdashboard.Exceptions.ProjectNotFoundException;
import com.stackroute.deploymentdashboard.domains.*;
import com.stackroute.deploymentdashboard.repository.*;

/*
 * Service for CRUD operations on PROJECT
 * 
 * */

@Service
public class ProjectManagementServiceImpl implements ProjectManagementService  {
	
	@Autowired
	private ProjectManagementCRUDRepository projectrepository;



	 ProjectManagementObject projectManagementObject=new ProjectManagementObject();
	
	public ProjectManagementCRUDRepository getProjectrepository() {
		return projectrepository;
	}

	public void setProjectrepository(ProjectManagementCRUDRepository projectrepository) {
		this.projectrepository = projectrepository;
	}

	
	/*
	 * Method for adding a Project
	 * */
	
	
	@Override
	public ProjectManagementObject addProject(ProjectManagementObject projectManagementObject) throws ProjectAlreadyExistsException {
		
		
		if (projectrepository.exists(projectManagementObject.getprojectId()))
				{
			throw new ProjectAlreadyExistsException("Project with Id " + projectManagementObject.getprojectId() + " already exist");
		} 
		else {
			projectrepository.save(projectManagementObject);
			return projectManagementObject;
		}
		
		
		
	}
	
	
	
	/*
	 * Method for getting  a Project by Id
	 * */
	@Override
	public ProjectManagementObject getByid(String id)throws ProjectNotFoundException{
		
		if (projectrepository.exists(id))
		{
	throw new ProjectNotFoundException("Project with Id doesnot exist");
		} 
		else {
			ProjectManagementObject projectManagementObject =projectrepository.findOne(id);
			return projectManagementObject;
}

		
		
		
		
	}
	
	
	/*
	 * Method for getting  a Project by ProjectId
	 * */
	@Override
	public ProjectManagementObject getproductid(String ProjectId)throws ProjectNotFoundException{

		if (projectrepository.exists(ProjectId))
		{ProjectManagementObject projectManagementObject =projectrepository.findByProjectId(ProjectId);
		return projectManagementObject;
		} 
		else {
			throw new ProjectNotFoundException("ProjectId with given Id doesnot exist");

}
		
		
	}

	/*
	 * Method for updating  a Project
	 * */
	@Override
	public ProjectManagementObject updateProject(ProjectManagementObject projectManagementObject)throws ProjectNotFoundException{
		
		if (projectrepository.exists(projectManagementObject.getId()))
		{
			projectrepository.save(projectManagementObject);
			return projectManagementObject;
		}
		
		else {
			
			throw new ProjectNotFoundException("Project with Id " + projectManagementObject.getId() + " not found");
		}
		
	}
	/*
	 * Method for deleting a Project
	 * */
	@Override
	public void deleteProject(String id)throws ProjectNotFoundException{

		if (projectrepository.exists(projectManagementObject.getId()))
		{
			projectrepository.delete(projectManagementObject);
		}
		
		else {
			
			throw new ProjectNotFoundException("Project with Id " + projectManagementObject.getId() + " not found");
		}
		
	}
	/*
	 * Method for listing  a Project
	 * */
	
	@Override
	public List<ProjectManagementObject> getAll()throws ProjectNotFoundException{
		if (projectrepository.findAll() == null) {
			throw new ProjectNotFoundException("No Project Found");
		} else {

		List<ProjectManagementObject> projectManagementObject=new ArrayList<>();
		projectrepository.findAll().forEach(projectManagementObject::add);
		return projectManagementObject;
	}

}
}
