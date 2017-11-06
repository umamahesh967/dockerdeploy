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
public class ProjectModel {

	@GraphId
	private Long id;

	private String name;

	private boolean status_active_project;

	@Relationship(type = "IS_DONE_BY", direction = Relationship.UNDIRECTED)
	private List<UserModel> users = new ArrayList<>();
	
	

	public ProjectModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public ProjectModel(Long id, String name, boolean status_active_project, List<UserModel> users) {
		super();
		this.id = id;
		this.name = name;
		this.status_active_project = status_active_project;
		this.users = users;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus_active_project() {
		return status_active_project;
	}

	public void setStatus_active_project(boolean status_active_project) {
		this.status_active_project = status_active_project;
	}

	public List<UserModel> getUsers() {
		return users;
	}

	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	
	
}
