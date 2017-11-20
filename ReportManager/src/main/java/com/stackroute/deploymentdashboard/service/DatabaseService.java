package com.stackroute.deploymentdashboard.service;

import java.util.List;

import com.stackroute.deploymentdashboard.model.ReportModel;

public interface DatabaseService {
	List<ReportModel> read();
	
	ReportModel SaveOrUpdate(ReportModel  userCredentials );
}
