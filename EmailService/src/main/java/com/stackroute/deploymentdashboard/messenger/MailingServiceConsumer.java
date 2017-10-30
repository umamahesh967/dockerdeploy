package com.stackroute.deploymentdashboard.messenger;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stackroute.deploymentdashboard.model.EmailCredentials;
import com.stackroute.deploymentdashboard.service.MailingServiceImpl;


public class MailingServiceConsumer {
	
	@Autowired
	MailingServiceImpl service;
	
	
	private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
      return latch;
    }
	@KafkaListener(topics = "trigger2", containerFactory = "reportKafkaListenerContainerFactory")
	public EmailCredentials reportlistener(EmailCredentials report) {
	   
		service.put(report);
		System.out.println(report.getEmailid());
		return report;
	}

}
