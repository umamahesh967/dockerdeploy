package com.stackroute.deploymentdashboard.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("UserCredentials")
public class UserCredentials {
	@PrimaryKey
	private String projectId; //project-id
    private String buildStatus; //status of the build
    
    //Constructors
	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	//constructors with fields

	
	
	public UserCredentials(String projectId, String buildStatus) {
		super();
		this.projectId = projectId;
		this.buildStatus = buildStatus;
	}
	
	
	public String getProjectId() {
		return projectId;
	}

	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getBuildStatus() {
		return buildStatus;
	}

	public void setBuildStatus(String buildStatus) {
		this.buildStatus = buildStatus;
	}
	 
	
	
    
    
    
	
}