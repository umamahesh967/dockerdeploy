package com.stackroute.deploymentdashboard.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class ProjectModel {

	@GraphId
	private Long id;
	
	private String projectID;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getProjectID() {
		return projectID;
	}



	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getProjectUrl() {
		return projectUrl;
	}



	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}



	public List<UserModel> getUsers() {
		return users;
	}



	public void setUsers(List<UserModel> users) {
		this.users = users;
	}



	private String projectName;
	
	private String projectUrl;

	

	@Relationship(type = "IS_DONE_BY", direction = Relationship.UNDIRECTED)
	private List<UserModel> users = new ArrayList<>();
	
	

	
	
}
