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
	
	
	@NotNull(message="pid cannot be null")
	private String pid;
	
	@NotNull(message="path cannot be null")
	private String path;
	
	@NotNull(message="repository url cannot be null")
	private String url;
	
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
	
    public void ManualModel(String pid,String path,String url) {
    	this.pid=pid;
    	this.path=path;
    	this.url=url;
		
	}
	
	  
}
