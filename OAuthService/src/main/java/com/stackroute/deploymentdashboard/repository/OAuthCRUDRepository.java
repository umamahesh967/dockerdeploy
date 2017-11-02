package com.stackroute.deploymentdashboard.repository;

import org.springframework.data.repository.CrudRepository;
import com.stackroute.deploymentdashboard.model.UserInfo;

public interface OAuthCRUDRepository extends CrudRepository<UserInfo, Long>{
	public UserInfo findByUsername(String username);
}
