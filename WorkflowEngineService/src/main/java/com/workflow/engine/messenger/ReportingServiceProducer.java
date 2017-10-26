package com.workflow.engine.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;


@Service
public class ReportingServiceProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 
	public void sendMessage(String report) {
	    kafkaTemplate.send("testrun4", report);
	}
}
