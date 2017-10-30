package com.stackroute.application.model;

public class HtmlModel {
  private String pid;
  private String uid;
  private String buildStatus;
  public HtmlModel(String pid, String uid, String buildStatus) {
		
		this.pid = pid; //pid is the project id
		this.uid = uid; //uid is the user id
		this.buildStatus = buildStatus; // buildStatus gives the status of the build
	}
  public HtmlModel() {
	  
  }
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getbuildStatus() {
	return buildStatus;
}
public void setbuildStatus(String buildStatus) {
	this.buildStatus = buildStatus;
}

}
