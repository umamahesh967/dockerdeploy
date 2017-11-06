package com.stackroute.deploymentdashboard.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import java.lang.annotation.Repeatable;

import javax.validation.Valid;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.messenger.ReportingServiceConsumer;
import com.stackroute.deploymentdashboard.model.EmailCredentials;
import com.stackroute.deploymentdashboard.service.MailingServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
public class Controller {
    

@Autowired
MailSender mailSender;

@Autowired
MailingServiceImpl mailingservice;
    
    @RequestMapping(value="/email")
 
    ///trying///
    @PostMapping(value="/send/{trigger}",consumes= {"application/json"})	
    @ApiOperation(value = "Sending mail")	
public ResponseEntity<String> projectadd(@PathVariable String trigger)throws Exception{
		
		try {
			mailingservice.sendmail(trigger);
			return new ResponseEntity<String>("mailed successfully",HttpStatus.OK);
			}
			catch (Exception exp) {
				return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
			}
		
		
	}
    
   
}

