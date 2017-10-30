package com.stackroute.deploymentdashboard.messenger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.ModelForJenkins;

@Service
public class ReportingServiceConsumer {
    
    @KafkaListener(topics="${spring.kafka.consumer.group-id}")
   public void processMessage(ModelForJenkins model) {
        System.out.println("received content = " + model);
   }
}
