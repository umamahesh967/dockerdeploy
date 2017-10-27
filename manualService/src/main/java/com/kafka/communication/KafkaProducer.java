package com.kafka.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.model.Model;
 
@Service
public class KafkaProducer {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, Model> kafkaTemplate;
	
//	@Value("${jsa.kafka.topic}")
//	String kafkaTopic = "jsa-test";
	
	@Value("${kafka.topic.bootnew}")
	String kafkaTopic = "${kafka.topic.bootnew}";
	
	
	public void send(Model data) {
	    log.info("sending data='{}'", data);
	    kafkaTemplate.send(kafkaTopic, data);
	   
	}
	
}