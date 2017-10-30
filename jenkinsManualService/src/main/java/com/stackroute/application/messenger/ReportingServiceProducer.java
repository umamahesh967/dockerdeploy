package com.stackroute.application.messenger;


import java.io.IOException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.application.exception.ModelNotFoundException;
import com.stackroute.application.exception.ModelVariableNotFoundException;
import com.stackroute.application.model.ManualModel;
import com.stackroute.application.model.ProduceManualModel;
import com.stackroute.application.service.ServiceManual;

import org.springframework.kafka.core.KafkaTemplate;


@Service
public class ReportingServiceProducer {
	
	@Autowired
	ServiceManual serviceManual;
	
	@Autowired
	private KafkaTemplate<String, ProduceManualModel> kafkaTemplate;
	
	@Value("${spring.kafka.producer.group-id}")
	private String groupid;
	 	
//	Gives the status of the project to kafka.
//	That status includes build status till now
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void sendMessage(ManualModel report) throws IOException, URISyntaxException {

//	    produces data object of produceManualModel(status of the project)
//	    into kafka through kafkaTemplate.send();
	    try {
	    kafkaTemplate.send(groupid, serviceManual.get());
	    }
	    catch(ModelVariableNotFoundException me) {        
			  logger.warn(me.getMessage()); 
		  }
	}
    
	
	
}
