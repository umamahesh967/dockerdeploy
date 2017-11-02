package com.stackroute.workflowengineservice.model;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class JenkinsJob implements Serializable {

	private String pid;
	private String path;
	
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	private String url;
	private String timeSpan;
	/**
	 * @param projectID
	 */

	public JenkinsJob(String projectID, String p) {
		this.pid = projectID;
		this.path = p;
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
		this.pid = pid2;
		this.path = path2;
		this.url = url2;
		this.timeSpan = null;
	}
	
	
}
