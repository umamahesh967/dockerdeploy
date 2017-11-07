package com.kafkaobject.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafkaobject.model.ProduceModel;
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
	  //sending string, object instead of string, string
	  @Autowired
	  private KafkaTemplate<String, ProduceModel> kafkaTemplate;
		@Value("${kafka.topic.producer}")
		private String kafkaTopic;
		//send function for producer
	  public void send( ProduceModel payload) {
	    LOGGER.info("sending payload='{}'", payload);
	    kafkaTemplate.send(kafkaTopic,payload);
	  }
}