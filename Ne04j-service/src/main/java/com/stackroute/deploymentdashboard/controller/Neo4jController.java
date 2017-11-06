package com.stackroute.deploymentdashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.model.ProjectModel;
import com.stackroute.deploymentdashboard.model.UserModel;
import com.stackroute.deploymentdashboard.service.Neo4jService;

@RestController
@RequestMapping("/v1.0/neo4jservice")
public class Neo4jController {

	@Autowired
	Neo4jService neo4jService;


	@RequestMapping("/users/{projectId}")
	public List<UserModel> getUsers(@PathVariable String projectId) {
		return neo4jService.findUsersUnderProject(projectId);
		
	}
	
	@RequestMapping("/projects/{userId}")
	public List<ProjectModel> getProject(@PathVariable  String userId) {
		return neo4jService.findProjectsUnderUser(userId);
		
	}
	
	@RequestMapping("/projects")
	public List<ProjectModel> getProjects() {
		return neo4jService.findAll();
		
	}
	
	@RequestMapping("/test")
	public String testing() {
		return "working fine....";
		
	}
}
