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
}
