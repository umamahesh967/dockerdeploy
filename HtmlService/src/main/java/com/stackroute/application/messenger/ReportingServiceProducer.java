package com.stackroute.application.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.application.model.HtmlModel;

import org.springframework.kafka.core.KafkaTemplate;


@Service
public class ReportingServiceProducer {
	@Autowired
	private KafkaTemplate<String, HtmlModel> kafkaTemplate;
	@Value("${spring.kafka.producer.group-id}")
	private String groupid;
	 	
	 
	public void sendMessage(HtmlModel report) {
	    kafkaTemplate.send(groupid, report);
	}
}
