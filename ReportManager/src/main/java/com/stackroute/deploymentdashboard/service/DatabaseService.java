package com.stackroute.deploymentdashboard.service;

import java.util.List;

import com.stackroute.deploymentdashboard.model.UserCredentials;

public interface DatabaseService {
	List<UserCredentials> read();
}
