package com.stackroute.deploymentdashboard.services;

import java.util.List;

import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;

public interface ProjectManagementService {

	ProjectManagementObject add();
	 ProjectManagementObject getByid();
	 ProjectManagementObject updateProject();
	 void deleteProject();
	 List<ProjectManagementObject> getAll();
}
