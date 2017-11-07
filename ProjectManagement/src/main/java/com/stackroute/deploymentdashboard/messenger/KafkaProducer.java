package com.stackroute.deploymentdashboard.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;

 
 
@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, ProjectManagementObject> kafkaTemplate;
    
    @Value("${spring.kafka.consumer.group-id}")
    private String kafkaTopic;
    
    public void send(ProjectManagementObject project) {
        System.out.println("sending data =" + project);
        kafkaTemplate.send(kafkaTopic, project);
    }
}
