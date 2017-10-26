package com.workflow.engine.model;

public class ModelForJenkins {

	private int projectID;
	private int versionID;
	private int buildID;
	private String path;
	private ModelForTime timestamp;
	
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public int getVersionID() {
		return versionID;
	}
	public void setVersionID(int versionID) {
		this.versionID = versionID;
	}
	public int getBuildID() {
		return buildID;
	}
	public void setBuildID(int buildID) {
		this.buildID = buildID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ModelForTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(ModelForTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
