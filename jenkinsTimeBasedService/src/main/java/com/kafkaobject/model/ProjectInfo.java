package com.kafkaobject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectInfo {
	@NotNull(message="project url cannot be null")
	private String repo_url;
	@NotNull(message="project id cannot be null")
	private String projectID;
	@NotNull(message="cloned path cannot be null")
	private String cloned_path;

	private String timeStamp; //in minutes
	
	public ProjectInfo(String projectID, String repo_url,  String cloned_path, String timeStamp) {
		
		this.projectID = projectID;
		this.repo_url = repo_url;		
		this.cloned_path = cloned_path;
		this.timeStamp = timeStamp;
	}

	public String getRepo_url() {
		return repo_url;
	}

	public void setRepo_url(String repo_url) {
		this.repo_url = repo_url;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getCloned_path() {
		return cloned_path;
	}

	public void setCloned_path(String cloned_path) {
		this.cloned_path = cloned_path;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public ProjectInfo(){
	}
}