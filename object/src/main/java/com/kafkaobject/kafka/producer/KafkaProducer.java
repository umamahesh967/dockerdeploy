package com.kafkaobject.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
 
import com.kafkaobject.model.Customer;
 
@Service
public class KafkaProducer {
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	@Value("testq")
	String kafkaTopic = "testq";
	
	public void send(Customer customer) {
	    System.out.println("sending data=" + customer);
	    kafkaTemplate.send(kafkaTopic, customer);
	}
}
  