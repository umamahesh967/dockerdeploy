/*
this file should contain your microservice data model
*/

package com.stackroute.application.model;


import javax.validation.constraints.NotNull;

/*
javax.validation.constraints must be present in your data model
check link: https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html 
TODO: needed
*/

public class ManualModel {
	
	
	private String pid;// project=id
	private String path;
	private String url; // git or svn url
	private String timeSpan; // time stamp when to build the project
	
    public String getTimeSpan() {
		return timeSpan;
	}
	public void setTimeSpan(String timeSpan) {
		this.timeSpan = timeSpan;
	}
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
	
	public void ManualModel() {
		
	}
	
    public void ManualModel(String pid,String path,String url,String timeSpan) {
    	this.pid=pid;
    	this.path=path;
    	this.url=url;
		this.timeSpan=timeSpan;
	}
	
	  
}
