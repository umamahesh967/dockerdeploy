package com.stackroute.deploymentdashboard.messenger;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.EmailCredentials;

@Service
public class ReportingServiceProducer { 
    @Autowired
    private KafkaTemplate<String, EmailCredentials> kafkaTemplate;
    @Value("${spring.kafka.producer.group-id}")
    private String groupid;
         
     
    public void sendMessage(EmailCredentials report) {
        kafkaTemplate.send(groupid, report);
    }


		
	
}


 
