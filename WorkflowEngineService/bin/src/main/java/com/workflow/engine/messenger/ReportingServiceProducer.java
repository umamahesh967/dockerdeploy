package com.workflow.engine.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.workflow.engine.model.ModelForJenkins;
 

 
@Service
public class ReportingServiceProducer {
	@Autowired
	private KafkaTemplate<String, ModelForJenkins> kafkaTemplate;
	
	@Value("${kafka.topic.bootnew}")
	String kafkaTopic = "${kafka.topic.bootnew}";
	
	public void send(ModelForJenkins model) {
	    System.out.println("sending data=" + model);
	    kafkaTemplate.send(kafkaTopic, model);
	}
}
  