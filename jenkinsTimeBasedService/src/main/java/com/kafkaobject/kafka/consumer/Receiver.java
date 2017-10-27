package com.kafkaobject.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


import com.kafkaobject.model.ProjectInfo;
 
@Service
public class Receiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
	private CountDownLatch latch = new CountDownLatch(2);

	  public CountDownLatch getLatch() {
	    return latch;
	  }

	
//	@KafkaListener(topics="${kafka.topic.receiver}")
//    public void processMessage(ProjectInfo customer) {
//		System.out.println("received content = " + customer);
//    }
	  //KafkaListener for listening to topic as mentioned in application properties
	  @KafkaListener(topics = "${kafka.topic.receiver}")
	  public void receive(ProjectInfo payload) {
	    LOGGER.info("received payload='{}'", payload);
	    latch.countDown();
	  }
}