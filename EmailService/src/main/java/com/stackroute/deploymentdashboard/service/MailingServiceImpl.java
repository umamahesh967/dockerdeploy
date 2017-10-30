package com.stackroute.deploymentdashboard.service;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.EmailCredentials;


@Service
public class MailingServiceImpl {
	
	
	EmailCredentials emailCredentials=new EmailCredentials();
	
	public EmailCredentials put(EmailCredentials report) {
		
		emailCredentials=report;
		createMail(report);
		return report;
	}


	private void createMail(EmailCredentials report) {
		// TODO Auto-generated method stub
		
	}
	



}
