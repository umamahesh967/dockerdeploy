package com.stackroute.deploymentdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.ProjectModel;
import com.stackroute.deploymentdashboard.model.UserModel;
import com.stackroute.deploymentdashboard.repository.ProjectRepository;
import com.stackroute.deploymentdashboard.repository.UserRepository;

@Service
public class Neo4jService {

	@Autowired
	private ProjectRepository  projectRepository ;
	
	@Autowired
	private UserRepository  userRepository ;
	
	public void saveUser(UserModel userModel)
	{
		userRepository.save(userModel);
	}
	
	public void saveProject(ProjectModel projectModel)
	{
		projectRepository.save(projectModel);
	}
	
	public List<ProjectModel> findProjectsUnderUser(String userId)
	{
		return userRepository.findProjects(userId);
		
	}
	
	public List<UserModel> findUsersUnderProject(String  projectId)
	{
		return projectRepository.findUsers(projectId);
		
	}
	
	public void addUser(UserModel userModel) {
		userRepository.save(userModel);
	}
	
	public void addProject(ProjectModel projectModel)
	{
		projectRepository.save(projectModel);
	}
	
	public void deleteUser(String userId) {
		userRepository.deleteUser(userId);
	}
	
	public void deleteProject(String projectId) {
		projectRepository.deleteProject(projectId);
	}
	
	public void addLink(String userId, String projectId) {
		projectRepository.saveLink(userId,projectId);
	}
	
	public void deleteLink(String userId, String projectId) {
		projectRepository.removeLink(userId, projectId);
	}

	public List<ProjectModel> findAll() {
		// TODO Auto-generated method stub
		return (List<ProjectModel>) projectRepository.findAll();
	}
	
}
