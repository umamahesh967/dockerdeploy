package com.stackroute.deploymentdashboard.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.deploymentdashboard.repository.ProjectRepository;
import com.stackroute.deploymentdashboard.repository.UserRepository;

public class Neo4jService {

	@Autowired
	private ProjectRepository  project_repository ;
	
	@Autowired
	private UserRepository  user_repository ;
	
	
}
