package com.stackroute.deploymentdashboard.usermanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.usermanagement.domains.UserModel;
 
 
@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, UserModel> kafkaTemplate;
    
    @Value("${kafka.topic.bootnew}")
    private String kafkaTopic;
    
    public void send(UserModel user) {
        System.out.println("sending data =" + user);
        kafkaTemplate.send(this.kafkaTopic, user);
    }
}
