package com.kafkaobject.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
 
import com.kafkaobject.model.ProjectInfo;
 
@Service
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, ProjectInfo> kafkaTemplate;
	
	@Value("jsa-test")
	String kafkaTopic = "jsa-test";
	
	public void send(ProjectInfo customer) {
	    System.out.println("sending data=" + customer);
	    kafkaTemplate.send(kafkaTopic, customer);
	}
}