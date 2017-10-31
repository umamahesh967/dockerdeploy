package com.stackroute.deploymentdashboard.messenger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.EmailCredentials;
import com.stackroute.deploymentdashboard.model.UserCredentials;
 

@Service
public class ReportingServiceConsumer {
    
    @KafkaListener(topics="${spring.kafka.consumer.group-id}")
   public void processMessage(UserCredentials user) {
        System.out.println("received content = " + user);
   }
    
    public UserCredentials reportlistener(UserCredentials user) {
 	   
		service.put(user);
		System.out.println("In Report Manager. Object Received");
		return user;
	}
}
