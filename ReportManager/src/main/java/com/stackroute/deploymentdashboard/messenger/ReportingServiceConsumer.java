package com.stackroute.deploymentdashboard.messenger;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.ReportModel;
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
    
    @KafkaListener(topics="${spring.kafka.consumer.name}",
    		containerFactory = "projectModelKafkaListenerContainerFactory")
   public void processMessage(ReportModel report) {
    	
        System.out.println("received content = " + report.getBuildStatus());
        LOGGER.info("received payload='{}'", report.getBuildStatus());
        latch.countDown();
    	cassandraDatabaseServiceImpl.SaveOrUpdate(report);
        System.out.println("received content = " + report.getBuildStatus());
        
   }
    
   
}
