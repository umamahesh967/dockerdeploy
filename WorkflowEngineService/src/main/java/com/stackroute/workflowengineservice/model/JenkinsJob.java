package com.stackroute.workflowengineservice.model;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class JenkinsJob implements Serializable {

	private String projectID;
	private String cloned_path;
	private String url;
	private String timeSpan;	
	
	public String getPid() {
		return projectID;
	}
	public void setPid(String pid) {
		this.projectID = pid;
	}
	public String getPath() {
		return cloned_path;
	}
	public void setPath(String path) {
		this.cloned_path = path;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTimeSpan() {
		return timeSpan;
	}
	public void setTimeSpan(String timeSpan) {
		this.timeSpan = timeSpan;
	}

	/**
	 * @param projectID
	 */

	public JenkinsJob(String projectID, String p) {
		this.projectID = projectID;
		this.cloned_path = p;
	}
	/**
	 * @param pid
	 * @param path
	 * @param url
	 * @param timeSpan
	 */

	public JenkinsJob(String pid2, String path2, String url2, String timeSpan2) {
		// TODO Auto-generated constructor stub
		super();
		this.projectID = pid2;
		this.cloned_path = path2;
		this.url = url2;
		this.timeSpan = null;
	}
	
	
}
