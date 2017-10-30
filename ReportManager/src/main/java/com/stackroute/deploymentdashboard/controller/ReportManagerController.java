package com.stackroute.deploymentdashboard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.model.UserCredentials;
import com.stackroute.deploymentdashboard.service.CassandraDatabaseServiceImpl;

@RestController
public class ReportManagerController {
	@Autowired
	private CassandraDatabaseServiceImpl _svnservice;
	
	/*
	perform checkout
	*/
	@GetMapping(value={"/checkout"})
	public ResponseEntity<String> performCheckout() {
		List<UserCredentials> list =  _svnservice.read();
		for(UserCredentials u : list) {
			System.out.println(u.getEmp_name());
		}
		return new ResponseEntity<String> ("Checkout done.", HttpStatus.CREATED);
	}
}
