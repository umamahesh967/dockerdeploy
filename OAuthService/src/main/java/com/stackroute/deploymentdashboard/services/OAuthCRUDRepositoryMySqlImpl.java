package com.stackroute.deploymentdashboard.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.UserInfo;
import com.stackroute.deploymentdashboard.repository.OAuthCRUDRepository;

@Service
public class OAuthCRUDRepositoryMySqlImpl implements OAuthCRUDRepositoryService {
	@Autowired
	PasswordEncoderService ps;
	
	@Autowired
	private OAuthCRUDRepository repoobject;
	
	@Override
	public long count() {
		return repoobject.count();
	}
	
	public List<UserInfo> getall() {
		return (List<UserInfo>) repoobject.findAll();
	}
		
	@Override
	public void save(UserInfo user) {
		user.setPassword(ps.getPasswordEncoder().encode(user.getPassword()));
		repoobject.save(user);
	}

	@Override
	public UserInfo findUser(String username) {
		return repoobject.findByUsername(username);
	}
}
