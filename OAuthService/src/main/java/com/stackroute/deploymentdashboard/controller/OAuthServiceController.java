package com.stackroute.deploymentdashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.model.UserInfo;
import com.stackroute.deploymentdashboard.services.OAuthCRUDRepositoryMySqlImpl;

@RestController
public class OAuthServiceController {
	@Autowired
	OAuthCRUDRepositoryMySqlImpl _service;
	
	@PostMapping(value="/register", consumes="application/json")
	public ResponseEntity<String> setUserInfo(RequestEntity<UserInfo> user) {
		_service.save(user.getBody());
		return new ResponseEntity<String> ("New user created.", HttpStatus.OK);
	}
}
