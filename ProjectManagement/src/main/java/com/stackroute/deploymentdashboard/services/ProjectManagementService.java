package com.stackroute.deploymentdashboard.services;

import java.util.List;

import com.stackroute.deploymentdashboard.Exceptions.ProjectAlreadyExistsException;
import com.stackroute.deploymentdashboard.Exceptions.ProjectNotFoundException;
import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;

public interface ProjectManagementService {

	ProjectManagementObject addProject(ProjectManagementObject projectManagementObject)throws ProjectAlreadyExistsException;
	ProjectManagementObject getByid(String id)throws ProjectNotFoundException;
	
	
	ProjectManagementObject getproductid(String ProjectId)throws ProjectNotFoundException;
	ProjectManagementObject updateProject(ProjectManagementObject projectManagementObject)throws ProjectNotFoundException;
	void deleteProject(String id)throws ProjectNotFoundException;
 List<ProjectManagementObject> getAll()throws ProjectNotFoundException;
}
