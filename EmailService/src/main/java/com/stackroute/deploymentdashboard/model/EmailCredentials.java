package com.stackroute.deploymentdashboard.model;

import java.math.BigInteger;

import javax.validation.constraints.NotNull;


public class EmailCredentials {
	
	@NotNull
	private String userId;
	@NotNull
	private String projectId;
	@NotNull
	private String emailid;
	@NotNull
	private String build;
	
		
	public EmailCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmailCredentials(String userId, String projectId, String emailid, String build) {
		super();
		this.userId = userId;
		this.projectId = projectId;
		this.emailid = emailid;
		this.build = build;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	
	

	
}