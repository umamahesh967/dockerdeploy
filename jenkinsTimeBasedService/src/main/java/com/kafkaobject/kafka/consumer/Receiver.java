package com.kafkaobject.kafka.consumer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafkaobject.kafka.service.JenkinsService;
import com.kafkaobject.model.ProjectInfo;
import com.kafkaobject.exception.*;
 
@Service
public class Receiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	private CountDownLatch latch = new CountDownLatch(2);

	  public CountDownLatch getLatch() {
	    return latch;
	  }

	  @Autowired
	  JenkinsService jenkinsService;
//	@KafkaListener(topics="${kafka.topic.receiver}")
//    public void processMessage(ProjectInfo customer) {
//		System.out.println("received content = " + customer);
//    }
	  //KafkaListener for listening to topic as mentioned in application properties
	  @KafkaListener(topics = "${spring.kafka.consumer.group-id}")
	  public void receive(ProjectInfo data) throws ModelNotFoundException, ModelVariableNotFoundException, URISyntaxException, IOException{
	    LOGGER.info("received data='{}'",data);
		  System.out.println(data.toString());
	    try {
	    	
			jenkinsService.put(data);
			  }
			  catch(ModelNotFoundException me) {				
				  LOGGER.info(me.getMessage());
			  }
			  catch(ModelVariableNotFoundException me) {				 
				  LOGGER.info(me.getMessage());
			  }
		
//	    System.out.println(payload);
		
			// TODO Auto-generated catch block
	
//	    ProjectInfo testing = payload;
//	    System.out.println("testing for shekhar " + payload.getUrl());
	    latch.countDown();
	  }
}