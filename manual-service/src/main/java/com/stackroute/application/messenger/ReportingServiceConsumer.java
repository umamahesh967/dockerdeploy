package com.stackroute.application.messenger;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Service;

import com.stackroute.application.model.ManualModel;

import org.springframework.kafka.annotation.KafkaListener;

@Service
public class ReportingServiceConsumer {
	
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
	    return latch;
	}
	

//	@KafkaListener(topics="${kafka.topic.bootnew}")
	@KafkaListener(topics="${spring.kafka.consumer.group-id}")
	public void reportlistener(ManualModel report) {
		System.out.println(report.getPath());
//	    latch.countDown();
	}
}