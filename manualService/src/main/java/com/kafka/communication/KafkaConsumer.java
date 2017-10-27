package com.kafka.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.model.Model;
import com.kafka.storage.MessageStorage;
 

 
@Component
public class KafkaConsumer {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
 
	@Autowired
	MessageStorage storage;
	
//	@KafkaListener(topics="${jsa.kafka.topic}")  (topics="jsa-test")
	@KafkaListener(topics="${kafka.topic.bootnew}") 
    public void processMessage(Model content) {
		log.info("received content = '{vamsi}'", content);
		
		storage.put(content);
    }
}