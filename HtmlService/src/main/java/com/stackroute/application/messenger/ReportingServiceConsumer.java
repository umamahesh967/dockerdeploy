package com.stackroute.application.messenger;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Service;

import com.stackroute.application.exception.ModelNotFoundException;
import com.stackroute.application.exception.ModelVariableNotFoundException;
import com.stackroute.application.model.HtmlModel;
import com.stackroute.application.service.HtmlService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


//This consumer takes data from kafka under topic log Data and sends to HtmlService

@Service
public class ReportingServiceConsumer {
	@Autowired
	HtmlService htmlService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@KafkaListener(topics = "${spring.kafka.consumer.group-id}")
	public void reportlistener(HtmlModel report) throws ModelVariableNotFoundException {
		
		// htmlService.put(report) puts the report in HtmlService
		try {
	  htmlService.put(report);
		}
		catch(ModelNotFoundException e) {
//			System.out.println(e);
			logger.warn(e.getMessage());
		}
		catch(ModelVariableNotFoundException e) {
//			System.out.println(e);
			logger.warn(e.getMessage());
		}
	}
}