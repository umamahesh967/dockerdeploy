package com.stackroute.deploymentdashboard.services;

import com.stackroute.deploymentdashboard.model.UserInfo;

public interface OAuthCRUDRepositoryService {
	public long count();
	public UserInfo findUser(String username);
	void save(UserInfo user);
}
