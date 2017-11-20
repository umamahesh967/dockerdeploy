package com.stackroute.deploymentdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.ReportModel;
import com.stackroute.deploymentdashboard.repository.ReportModelCRUDRepository;

@Service
public class CassandraDatabaseServiceImpl implements DatabaseService {
	@Autowired
	private ReportModelCRUDRepository repoObject;
	
	
	
	public ReportModelCRUDRepository getRepoObject() {
		return repoObject;
	}

	public void setRepoObject(ReportModelCRUDRepository repoObject) {
		this.repoObject = repoObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReportModel> read() {
		@SuppressWarnings("unchecked")
		List<ReportModel> usercredentialsList = (List<ReportModel>) repoObject.findAll();
		return usercredentialsList;
	}

	@Override
	public ReportModel SaveOrUpdate(ReportModel userCredentials) {
		ReportModel usrCredentials=repoObject.save(userCredentials);
		return usrCredentials;
	}
	
	
}
