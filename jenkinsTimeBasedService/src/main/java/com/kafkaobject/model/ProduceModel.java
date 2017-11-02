package com.kafkaobject.model;


public class ProduceModel {
	
	private String pid; //project-id
	private String buildSuccess; //status of the build
	
	public ProduceModel() {
		
	}

	public ProduceModel(String pid, String buildSuccess) {
		
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
