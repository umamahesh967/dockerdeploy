package com.stackroute.deploymentdashboard.repository;

import java.util.List;

import com.stackroute.deploymentdashboard.model.ModelForJenkins;

public interface DatabaseService {
	List<ModelForJenkins> read();
}
