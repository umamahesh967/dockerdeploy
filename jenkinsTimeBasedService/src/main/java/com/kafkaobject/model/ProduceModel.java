package com.kafkaobject.model;


public class ProduceModel {
	

	private String buildSuccess; //status of the build
	private String projectId; //project-id
	
	public ProduceModel() {
		
	}

	public ProduceModel( String buildSuccess, String projectId) {
		
	
		this.buildSuccess = buildSuccess;
		this.projectId = projectId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getBuildSuccess() {
		return buildSuccess;
	}
	public void setBuildSuccess(String buildSuccess) {
		this.buildSuccess = buildSuccess;
	}
	
	

}
