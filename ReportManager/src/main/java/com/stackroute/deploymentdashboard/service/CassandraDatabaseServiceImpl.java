package com.stackroute.deploymentdashboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.UserCredentials;
import com.stackroute.deploymentdashboard.repository.UserCredentialsCRUDRepository;

@Service
public class CassandraDatabaseServiceImpl implements DatabaseService {
	@Autowired
	private UserCredentialsCRUDRepository repoObject;
	
	@Override
	public List<UserCredentials> read() {
		List<UserCredentials> usercredentialsList = (List<UserCredentials>) repoObject.findAll();
		return usercredentialsList;
	}
}
