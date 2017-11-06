package com.kafkaobject.model;


public class ProduceModel {
	
	private String projectId; //project-id
	private String buildSuccess; //status of the build
	
	public ProduceModel() {
		
	}

	public ProduceModel(String projectId, String buildSuccess) {
		
		this.projectId = projectId;
		this.buildSuccess = buildSuccess;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setPid(String projectId) {
		this.projectId = projectId;
	}
	public String getBuildSuccess() {
		return buildSuccess;
	}
	public void setBuildSuccess(String buildSuccess) {
		this.buildSuccess = buildSuccess;
	}
	
	

}
