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
	
	private String name;
	private int age;
	private String gender;
	private boolean status_active_user;
	
	@Relationship(type = "WORKS_IN", direction = Relationship.UNDIRECTED)
	private List<ProjectModel> projects = new ArrayList<>();
	
}
