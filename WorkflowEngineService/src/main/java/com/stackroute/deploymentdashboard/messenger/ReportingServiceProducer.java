package com.stackroute.deploymentdashboard.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


/*
 * For producer
 * */
@Service
public class ReportingServiceProducer {
    
	/*
	 * for now testing with string. It will be replaced to ModelForJenkins.
	 * 
	 * */
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    //@Value("${kafka.topic.bootnew}")
    String kafkaTopic = "trigger11234"; 
    // "${kafka.topic.bootnew}";
    
    // refer : https://kafka.apache.org/quickstart
    public void send(String model) {
        System.out.println("sending data=" + model);
        System.out.println(kafkaTopic);
        kafkaTemplate.send(kafkaTopic, model);
//        System.out.println("sending done ...........yooooooooooooo" );
    }
}