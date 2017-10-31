package com.stackroute.deploymentdashboard.repository;

import java.util.List;

import com.stackroute.deploymentdashboard.model.JenkinsJob;


public interface DatabaseService {
	List<JenkinsJob> read();
}
