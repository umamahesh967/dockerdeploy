package com.stackroute.application.model;


public class ProduceManualModel {
	
	
	private String buildStatus; //status of the build
	private String projectId; //project-id
	
	public ProduceManualModel() {
		
	}

	public ProduceManualModel (String buildStatus, String projectId) {
		
		
		this.buildStatus = buildStatus;
		this.projectId = projectId;
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
