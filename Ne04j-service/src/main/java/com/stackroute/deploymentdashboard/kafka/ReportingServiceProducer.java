package com.stackroute.deploymentdashboard.kafka;

import java.io.IOException;
import java.net.URISyntaxException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.exceptions.ModelVariableNotFoundException;
import com.stackroute.deploymentdashboard.model.UserProjectModel;

@Service
public class ReportingServiceProducer {
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportingServiceProducer.class);
	  
	@Autowired
	private KafkaTemplate<String, UserProjectModel> kafkaTemplate;
	
	@Value("${spring.kafka.producer.group-id}")
	private String topicName;
	 
	public void sendMessage(UserProjectModel msg) throws IOException, URISyntaxException  {

//		try {
	    kafkaTemplate.send(topicName, msg);
//		}
//	    catch(ModelVariableNotFoundException me) {        
//	    	LOGGER.warn(me.getMessage()); 
//		}
	}

}
