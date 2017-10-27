package com.stackroute.deploymentdashboard.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class ReportingServiceProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Value("${kafka.topic.bootnew}")
    String kafkaTopic = "trigger112"; // "${kafka.topic.bootnew}";
    
    public void send(String model) {
        System.out.println("sending data=" + model);
        System.out.println(kafkaTopic);
        kafkaTemplate.send(kafkaTopic, "he.llloo");
        System.out.println("sending done ...........yooooooooooooo" );
    }
}