package com.stackroute.deploymentdashboard.messenger;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.UserCredentials;
import com.stackroute.deploymentdashboard.service.CassandraDatabaseServiceImpl;
 

@Service
public class ReportingServiceConsumer {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(ReportingServiceConsumer.class);

	  private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		
	    return latch;
	}

	@Autowired
	private CassandraDatabaseServiceImpl cassandraDatabaseServiceImpl;
    
    @KafkaListener(topics="${spring.kafka.consumer.group-id}",
    		containerFactory = "projectModelKafkaListenerContainerFactory")
   public void processMessage(UserCredentials user) {
    	
        System.out.println("received content = " + user.getProjectid());
        LOGGER.info("received payload='{}'", user.getProjectid());
        latch.countDown();
    	cassandraDatabaseServiceImpl.SaveOrUpdate(user);
        System.out.println("received content = " + user.getProjectid());
        
   }
    
   
}
