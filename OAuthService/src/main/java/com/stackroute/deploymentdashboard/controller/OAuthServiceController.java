package com.stackroute.deploymentdashboard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.model.UserInfo;
import com.stackroute.deploymentdashboard.services.OAuthCRUDRepositoryMySqlImpl;

@RestController
public class OAuthServiceController {
	@Autowired
	OAuthCRUDRepositoryMySqlImpl mysqlservice;
	
	@Autowired
	ConsumerTokenServices tokenservice;
	
	@PostMapping(value="/register", consumes="application/json")
	public ResponseEntity<String> setUserInfo(@Valid @RequestBody UserInfo user) {
		mysqlservice.save(user);
		return new ResponseEntity<String> ("New user created.", HttpStatus.OK);
	}
	
	@GetMapping(value="/revoketoken")
	public ResponseEntity<String> deleteToken(@RequestHeader(value="Authorization") String accesstoken) {
		String[] splittedtoken = accesstoken.split(" ");
		tokenservice.revokeToken(splittedtoken[1]);
		return new ResponseEntity<String> ("Access token revoked", HttpStatus.OK);
	}
}
