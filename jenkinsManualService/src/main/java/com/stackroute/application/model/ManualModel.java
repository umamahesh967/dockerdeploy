/*
this file should contain your microservice data model
*/

package com.stackroute.application.model;


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/*
javax.validation.constraints must be present in your data model
check link: https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html 
TODO: needed
*/
@JsonDeserialize
public class ManualModel {
	private String projectID;
	private String cloned_path;
	private String repo_url; // git or svn url
	 private String timeStamp; // time stamp when to build the project
	
	 public ManualModel(String projectID, String cloned_path, String repo_url, String timeStamp) {
			
			
			this.projectID = projectID;
			this.cloned_path = cloned_path;
			this.repo_url = repo_url;
			this.timeStamp = timeStamp;
		}
	 public ManualModel() {
		 
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
	public String getRepo_url() {
		return repo_url;
	}
	public void setRepo_url(String repo_url) {
		this.repo_url = repo_url;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
  
	  
}
