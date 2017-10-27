package com.kafkaobject.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.kafkaobject.model.ProjectInfo;
 
@Service
public class Sender {
//	@Autowired
//	private KafkaTemplate<String, ProjectInfo> kafkaTemplate;
//	
//	@Value("jsa-test")
//	String kafkaTopic = "jsa-test";
//	
//	public void send(ProjectInfo customer) {
//	    System.out.println("sending data=" + customer);
//	    kafkaTemplate.send(kafkaTopic, customer);
//	}
	  private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	  @Autowired
	  private KafkaTemplate<String, ProjectInfo> kafkaTemplate;

	  public void send(String topic, ProjectInfo payload) {
	    LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
	    kafkaTemplate.send(topic, payload);
	  }
}