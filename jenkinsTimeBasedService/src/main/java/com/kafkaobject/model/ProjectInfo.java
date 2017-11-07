package com.kafkaobject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectInfo {
	@NotNull(message="project url cannot be null")
	private String repoUrl;
	@NotNull(message="project id cannot be null")
	private String projectId;
	@NotNull(message="cloned path cannot be null")
	private String clonedPath;

	private String timeStamp; //in minutes
	
	public ProjectInfo(String projectId, String repoUrl,  String clonedPath, String timeStamp) {
		
		this.projectId = projectId;
		this.repoUrl = repoUrl;		
		this.clonedPath = clonedPath;
		this.timeStamp = timeStamp;
	}

	public String getRepoUrl() {
		return repoUrl;
	}

	public void setRepo_url(String repoUrl) {
		this.repoUrl = repoUrl;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getClonedPath() {
		return clonedPath;
	}

	public void setClonedPath(String clonedPath) {
		this.clonedPath = clonedPath;
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