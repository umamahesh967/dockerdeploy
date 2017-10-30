package com.stackroute.deploymentdashboard.messenger;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.deploymentdashboard.model.UserCredentials;
 
@Service
public class KafkaConsumer {
	
	private CountDownLatch latch = new CountDownLatch(2);

	  public CountDownLatch getLatch() {
	    return latch;
	  }

	
//	@KafkaListener(topics="jsa-test")
//    public void processMessage(UserCredentials customer) {
//		System.out.println("received content = " + customer);
//    }
}