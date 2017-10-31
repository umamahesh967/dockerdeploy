package com.stackroute.application.model;


public class ProduceManualModel {
	
	private String projectID; //project-id
	private String buildStatus; //status of the build
	
	public ProduceManualModel() {
		
	}

	public ProduceManualModel(String projectID, String buildStatus) {
		
		this.projectID = projectID;
		this.buildStatus = buildStatus;
	}
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getBuildStatus() {
		return buildStatus;
	}
	public void setBuildStatus(String buildStatus) {
		this.buildStatus = buildStatus;
	}
	
	

}
