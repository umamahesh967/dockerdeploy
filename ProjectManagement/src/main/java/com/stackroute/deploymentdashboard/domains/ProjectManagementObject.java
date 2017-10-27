package com.stackroute.deploymentdashboard.domains;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

/*
 Object class for the project  with attributes projectid ,version id,roles,commands,accesstoken
  */


@Entity
@Document(collection="Project")
public class ProjectManagementObject {
	
	@Id
	private String id;

	@ApiModelProperty
	@NotNull
	private String projectId;
	
	@ApiModelProperty
	@NotNull
	private String versionId;
	
	
	@ApiModelProperty
	@NotNull
	private ArrayList<String> owner;
	
	@ApiModelProperty
	@NotNull
	private ArrayList<String>developer;
	
	@ApiModelProperty
	@NotNull
	private ArrayList<String>stakeholder;
	

	@ApiModelProperty
	@NotNull
	private ArrayList<String>commands;
	
	@ApiModelProperty
	@NotNull
	private String Url;
	
	@ApiModelProperty
	@NotNull
	private String Accesstoken;
	//constructors

	
	
	public ProjectManagementObject() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAccesstoken() {
		return Accesstoken;
	}


	public void setAccesstoken(String accesstoken) {
		Accesstoken = accesstoken;
	}


	public ProjectManagementObject(String id, String projectId, String versionId, ArrayList<String> owner, ArrayList<String> developer,
			ArrayList<String> stakeholder,ArrayList<String> commands, String url,String Accesstoken) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.versionId = versionId;
		this.owner = owner;
		this.developer = developer;
		this.stakeholder = stakeholder;
		this.commands = commands;
		
		Url = url;
	}
	
	
	
	/*
	 * Getter and  setter methods for all attributes of PROJECT object
	 * */

	public ArrayList<String> getCommands() {
		return commands;
	}


	public void setCommands(ArrayList<String> commands) {
		this.commands = commands;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getprojectId() {
		return projectId;
	}

	public void setprojectId(String projectId) {
		this.projectId = projectId;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public ArrayList<String> getOwner() {
		return owner;
	}

	public void setOwner(ArrayList<String> owner) {
		this.owner = owner;
	}

	public ArrayList<String> getDeveloper() {
		return developer;
	}

	public void setDeveloper(ArrayList<String> developer) {
		this.developer = developer;
	}

	public ArrayList<String> getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(ArrayList<String> stakeholder) {
		this.stakeholder = stakeholder;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
    

}
