package com.stackroute.deploymentdashboard.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.ModelForJenkins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * For producer
 *
 */
@Service
public class ReportingServiceProducer {
    
	 private static final Logger LOGGER = LoggerFactory.getLogger(ReportingServiceProducer.class);

	/*
	 * for now testing with string. It will be replaced to ModelForJenkins.
	 * 
	 * */
	@Autowired
    private KafkaTemplate<String, ModelForJenkins> kafkaTemplate;
    
//    @Value("${spring.kafka.producer.group-id}")
    String kafkaTopic = "testingzero";// = "trigger11234"; 
    // "${kafka.topic.bootnew}";
    
    // refer : https://kafka.apache.org/quickstart
    public void send(ModelForJenkins model) {
    	LOGGER.info("sending payload='{}'", model);
        System.out.println("sending data=" + model);
        System.out.println(kafkaTopic);
        kafkaTemplate.send(kafkaTopic, model);
        System.out.println("sending " +  " done ..........." );
    }
}

