package com.stackroute.application.messenger;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Service;

import com.stackroute.application.model.HtmlModel;
import com.stackroute.application.service.HtmlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class ReportingServiceConsumer {
	@Autowired
	HtmlService htmlService;
	
	
	@KafkaListener(topics = "${spring.kafka.consumer.group-id}")
	public void reportlistener(HtmlModel report) {
	  htmlService.put(report);
	}
}