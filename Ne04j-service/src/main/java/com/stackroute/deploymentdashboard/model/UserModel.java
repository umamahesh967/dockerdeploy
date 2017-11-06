package com.stackroute.deploymentdashboard.model;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class UserModel {

	@GraphId
	private Long id;
	
	private String userId;
	private String userName;
	private  String emailId;
	private String gender;
	private String userStatus;


	@Relationship(type = "WORKS_IN", direction = Relationship.UNDIRECTED)
	private List<ProjectModel> projects = new ArrayList<>();

	

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public UserModel(Long id, String userId, String userName, String emailId, String gender, String userStatus,
			List<ProjectModel> projects) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.gender = gender;
		this.userStatus = userStatus;
		this.projects = projects;
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	public List<ProjectModel> getProjects() {
		return projects;
	}


	public void setProjects(List<ProjectModel> projects) {
		this.projects = projects;
	}
	
	
	
}
