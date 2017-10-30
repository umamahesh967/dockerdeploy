package com.stackroute.deploymentdashboard.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailServiceController {
	/*
	perform checkout
	*/
	@GetMapping(value={"/checkout"})
	public ResponseEntity<String> performCheckout() {
		return new ResponseEntity<String> ("Checkout done.", HttpStatus.CREATED);
	}
}
