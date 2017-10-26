package com.workflow.engine.messenger;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class ReportingServiceConsumer {
	
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
	    return latch;
	}
	
	
	@KafkaListener(topics = "testrun4", containerFactory = "reportKafkaListenerContainerFactory")
	public void reportlistener(String report) {
	    latch.countDown();
	}
}