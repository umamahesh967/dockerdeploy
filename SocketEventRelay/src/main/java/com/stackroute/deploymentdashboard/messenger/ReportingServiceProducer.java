package com.stackroute.deploymentdashboard.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.UserCredentials;


@Service
public class ReportingServiceProducer {
	@Autowired
	private KafkaTemplate<String, UserCredentials> kafkaTemplate;
	@Value("${spring.kafka.producer.group-id}")
	private String groupid;
	 	
	 
	public void sendMessage(UserCredentials user) {
	    kafkaTemplate.send(groupid, user);
	}
}
