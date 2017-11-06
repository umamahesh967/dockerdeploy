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
	
	public ProjectManagementCRUDRepository getprojectrepository() {
		return this.projectrepository;
	}

	public void setprojectrepository(ProjectManagementCRUDRepository projectrepository) {
		this.projectrepository = this.projectrepository;
	}

	
	
	/*
	 * Method for listing  a Project
	 * */
	
	
	
	@Override
	public List<ProjectManagementObject> getAll()throws ProjectNotFoundException{
		if (this.projectrepository.findAll() == null) {
			throw new ProjectNotFoundException("No Project Found");
		} else {

		List<ProjectManagementObject> projectManagementObject=new ArrayList<>();
		this.projectrepository.findAll().forEach(projectManagementObject::add);
		return projectManagementObject;
		}
	}
	
	/*
	 * Method for adding a Project
	 * */
	
	
	@Override
	public void addProject(ProjectManagementObject projectManagementObject) throws ProjectAlreadyExistsException {
		
		
		if (this.projectrepository.exists(projectManagementObject.getprojectID()))
				{
			throw new ProjectAlreadyExistsException("Project with Id " + projectManagementObject.getprojectID() + " already exist");
		} 
		else {
			this.projectrepository.save(projectManagementObject);
		}
		
		
		
	}
	
	
	


	
	/*
	 * Method for getting  a Project by ProjectId
	 * */
	@Override
	public ProjectManagementObject getprojectid(String ProjectId)throws ProjectNotFoundException{

		if (this.projectrepository.exists(ProjectId))
		{
			ProjectManagementObject projectManagementObject =this.projectrepository.findByProjectID(ProjectId);
	
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
	public void updateProject(ProjectManagementObject projectManagementObject)throws ProjectNotFoundException{
		
		if (this.projectrepository.exists(projectManagementObject.getprojectID()))
		{
			this.projectrepository.save(projectManagementObject);
		}
		
		else {
			
			throw new ProjectNotFoundException("Project with Id " + projectManagementObject.getprojectID() + " not found");
		}
		
	}
	/*
	 * Method for deleting a Project
	 * */
	
	@Override
	public void deleteById(String projectID) throws ProjectNotFoundException {
		if (this.projectrepository.exists(projectID)) 
		{
			this.projectrepository.delete(projectID);		
			}
		else {
			throw new ProjectNotFoundException("project with Id " + projectID + " does not exist");
		}

	}
	


}
