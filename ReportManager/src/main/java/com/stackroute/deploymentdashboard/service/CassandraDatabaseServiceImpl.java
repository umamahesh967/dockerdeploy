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
	
	
	
	public UserCredentialsCRUDRepository getRepoObject() {
		return repoObject;
	}

	public void setRepoObject(UserCredentialsCRUDRepository repoObject) {
		this.repoObject = repoObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserCredentials> read() {
		@SuppressWarnings("unchecked")
		List<UserCredentials> usercredentialsList = (List<UserCredentials>) repoObject.findAll();
		return usercredentialsList;
	}

	@Override
	public UserCredentials SaveOrUpdate(UserCredentials userCredentials) {
		UserCredentials usrCredentials=repoObject.save(userCredentials);
		return usrCredentials;
	}
	
	
}
