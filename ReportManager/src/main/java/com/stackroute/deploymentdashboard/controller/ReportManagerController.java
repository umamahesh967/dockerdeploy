package com.stackroute.deploymentdashboard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.model.ReportModel;
import com.stackroute.deploymentdashboard.service.CassandraDatabaseServiceImpl;

@RestController
public class ReportManagerController {
	@Autowired
	private CassandraDatabaseServiceImpl _svnservice;
	
	/*
	perform checkout
	*/
	@GetMapping(value={"/checkout"})
	public ResponseEntity<List<ReportModel>> performCheckout() {
		List<ReportModel> list =  _svnservice.read();
		for(ReportModel u : list) {
			System.out.println(u.getBuildStatus());
		}
		return new ResponseEntity<List<ReportModel>> (list, HttpStatus.CREATED);
	}
	
	@PostMapping(value={"/add"})
	public ResponseEntity<String> add(@RequestBody ReportModel user) {
		ReportModel addeduser=  _svnservice.SaveOrUpdate(user);
		
		return new ResponseEntity<String> ("added user....", HttpStatus.CREATED);
	}
	
	
}
