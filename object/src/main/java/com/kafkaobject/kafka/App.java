package com.kafkaobject.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import com.kafkaobject.model.Customer;
import com.kafkaobject.kafka.producer.KafkaProducer;;
 
 
@SpringBootApplication
public class App implements CommandLineRunner{
 
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Autowired
	KafkaProducer producer;
	
	@Override
	public void run(String... arg0) throws Exception {
		// Send Mary customer
		Customer mary = new Customer("Mary", 31);
		producer.send(mary);
		
		// Send Peter customer
		Customer peter = new Customer("Peter", 24);
		producer.send(peter);
	}
}