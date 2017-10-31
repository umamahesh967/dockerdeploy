package com.stackroute.application.model;

public class HtmlModel {
  private String projectID;
  
  private String buildStatus;
  public HtmlModel(String projectID, String buildStatus) {
		
		this.projectID = projectID; //projectID is the project id
		 
		this.buildStatus = buildStatus; // buildStatus gives the status of the build
	}
  public HtmlModel() {
	  
  }
public String getProjectID() {
	return projectID;
}
public void setProjectID(String projectID) {
	this.projectID = projectID;
}


public String getBuildStatus() {
	return buildStatus;
}
public void setBuildStatus(String buildStatus) {
	this.buildStatus = buildStatus;
}

}
