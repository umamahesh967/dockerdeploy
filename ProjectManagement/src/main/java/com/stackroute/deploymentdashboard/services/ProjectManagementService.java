package com.stackroute.deploymentdashboard.services;

import java.util.List;

import com.stackroute.deploymentdashboard.Exceptions.ProjectAlreadyExistsException;
import com.stackroute.deploymentdashboard.Exceptions.ProjectNotFoundException;
import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;

public interface ProjectManagementService {

	void  addProject(ProjectManagementObject projectManagementObject)throws ProjectAlreadyExistsException;
//	ProjectManagementObject getByid(String id)throws ProjectNotFoundException;
	
	
	ProjectManagementObject getprojectid(String ProjectId)throws ProjectNotFoundException;
	
	void updateProject(ProjectManagementObject projectManagementObject)throws ProjectNotFoundException;
	
	void deleteById(String projectID)throws ProjectNotFoundException;
	
 List<ProjectManagementObject> getAll()throws ProjectNotFoundException;
 
}
