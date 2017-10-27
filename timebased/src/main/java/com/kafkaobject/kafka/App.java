package com.kafkaobject.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.kafkaobject.model.ProjectInfo;
import com.kafkaobject.exception.SendingDataException;
import com.kafkaobject.kafka.producer.Sender;;
 
 
@SpringBootApplication
@EnableDiscoveryClient
public class App implements CommandLineRunner{
 
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Autowired
	Sender producer;
	
	@Override
	public void run(String... arg0) throws Exception {
		try {
		// Send fb customer
		ProjectInfo facebook = new ProjectInfo("fb.com", 31);
		producer.send("receiver", facebook);
		}
		catch (Exception e) {
			
			throw new SendingDataException("Problem sending data");
		}
		try {
		// Send Peter customer
		ProjectInfo peter = new ProjectInfo("spiderman.com", 24);
		producer.send("receiver",peter);
		}catch (Exception e) {
			
			throw new SendingDataException("Problem sending data");
		}
	}
}