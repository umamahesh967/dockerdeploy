package com.stackroute.deploymentdashboard.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("ReportModel")

public class ReportModel {
	@PrimaryKey
	private String projectId; //project-id
	
	@Column
    private String buildStatus; //status of the build
	
	@Column
    private String consoleOutput;
    
    //Constructors
	public ReportModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructors with fields

	public ReportModel(String projectId, String buildStatus, String consoleOutput) {
		super();
		this.projectId = projectId;
		this.buildStatus = buildStatus;
		this.consoleOutput = consoleOutput;
	}
	
	
	public String getConsoleOutput() {
		return consoleOutput;
	}

	public void setConsoleOutput(String consoleOutput) {
		this.consoleOutput = consoleOutput;
	}

	public String getProjectId() {
		return projectId;
	}

	
	
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getBuildStatus() {
		return buildStatus;
	}

	public void setBuildStatus(String buildStatus) {
		this.buildStatus = buildStatus;
	}
	
}