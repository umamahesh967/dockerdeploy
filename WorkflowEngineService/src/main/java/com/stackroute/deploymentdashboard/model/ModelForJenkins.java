package com.stackroute.deploymentdashboard.model;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ModelForJenkins implements Serializable {

	private int projectID;
	private String path;
	/**
	 * @param projectID
	 */

	public ModelForJenkins(int projectID, String p) {
		this.projectID = projectID;
		this.path = p;
	}
	
	
}
