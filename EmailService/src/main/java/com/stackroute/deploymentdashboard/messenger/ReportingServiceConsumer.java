package com.stackroute.deploymentdashboard.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.deploymentdashboard.model.EmailCredentials;
import com.stackroute.deploymentdashboard.service.MailingServiceImpl;


public class ReportingServiceConsumer {
	
	@Autowired
	MailingServiceImpl service;
	
	
	
	@KafkaListener(topics = "{${spring.kafka.consumer.group-id}}")//, containerFactory = "reportKafkaListenerContainerFactory")
	public EmailCredentials reportlistener(EmailCredentials report) {
	   
		service.put(report);
		System.out.println(report.getEmailid());
		return report;
	}

}
