package com.kafkaobject.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
 
import com.kafkaobject.model.ProjectInfo;
 
@Service
public class KafkaConsumer {
	
	private CountDownLatch latch = new CountDownLatch(2);

	  public CountDownLatch getLatch() {
	    return latch;
	  }

	
	@KafkaListener(topics="jsa-test")
    public void processMessage(ProjectInfo customer) {
		System.out.println("received content = " + customer);
    }
}