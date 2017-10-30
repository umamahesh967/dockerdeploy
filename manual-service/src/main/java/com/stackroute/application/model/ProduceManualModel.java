package com.stackroute.application.model;

public class ProduceManualModel {
	
	private String pid; //project-id
	private String buildSuccess; //status of the build
	
	public ProduceManualModel() {
		
	}

	public ProduceManualModel(String pid, String buildSuccess) {
		
		this.pid = pid;
		this.buildSuccess = buildSuccess;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getBuildSuccess() {
		return buildSuccess;
	}
	public void setBuildSuccess(String buildSuccess) {
		this.buildSuccess = buildSuccess;
	}
	
	

}
