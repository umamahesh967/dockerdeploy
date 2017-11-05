package com.stackroute.deploymentdashboard.model;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("UserCredentials")
public class UserCredentials {
	@PrimaryKey
	private String projectid; //project-id
    private String buildstatus; //status of the build
    
    //Constructors
	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	//constructors with fields
	 
	
	public String getProjectid() {
		return projectid;
	}
	
	

	public UserCredentials(String projectid, String buildstatus) {
		super();
		this.projectid = projectid;
		this.buildstatus = buildstatus;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getBuildstatus() {
		return buildstatus;
	}

	public void setBuildstatus(String buildstatus) {
		this.buildstatus = buildstatus;
	}
	
	
    
    
    
	
}