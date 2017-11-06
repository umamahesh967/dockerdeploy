package com.stackroute.deploymentdashboard.domains;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

/*
 Object class for the project  with attributes projectid ,version id,roles,configurations,accesstoken
  */


@Document(collection="Project")
public class ProjectManagementObject {
	

//	private String id;

	
	@Id
	private String projectID;
	
//	@ApiModelProperty
//	@NotNull
//	private String versionId;
	
	@ApiModelProperty
	@NotNull
	private String projectName;
	
	@ApiModelProperty
	@NotNull
	private String projectUrl;

	
	
	public ProjectManagementObject() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ProjectManagementObject(String projectID, String projectName, String projectUrl) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.projectUrl = projectUrl;
	}



	public String getprojectID() {
		return projectID;
	}



	public void setprojectID(String projectID) {
		this.projectID = projectID;
	}



	public String getprojectName() {
		return projectName;
	}



	public void setprojectName(String projectName) {
		this.projectName = projectName;
	}



	public String getprojectUrl() {
		return projectUrl;
	}



	public void setprojectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}
}

	