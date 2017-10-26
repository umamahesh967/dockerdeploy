package com.kafkaobject.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
 
import com.kafkaobject.model.Customer;
 
@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="testq")
    public void processMessage(Customer customer) {
		System.out.println("received content = " + customer);
    }
}