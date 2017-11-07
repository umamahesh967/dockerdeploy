package com.kafkaobject.kafka;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.Scheduled;

import com.kafkaobject.model.ProjectInfo;
import com.kafkaobject.exception.ModelNotFoundException;
import com.kafkaobject.exception.ModelVariableNotFoundException;
import com.kafkaobject.exception.SendingDataException;
import com.kafkaobject.kafka.producer.Sender;
import com.kafkaobject.kafka.service.JenkinsService;;
 
 
@SpringBootApplication
//@EnableDiscoveryClient
public class App{
 
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
//		JenkinsService jenkinsService = new JenkinsService();
//		ProjectInfo model = new ProjectInfo( "27","/home/ankur/Downloads/gs-maven-master/complete", "/usr/", "1");
//		try {
//			jenkinsService.put(model);
//		} catch (ModelNotFoundException | ModelVariableNotFoundException | URISyntaxException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}
	
//	@Autowired
//	Sender producer;
	//for testing of send and receive
//	@Override
	
//	public void run(String... arg0) throws Exception {
//		try {
////		 Send fb customer
//		ProjectInfo facebook = new ProjectInfo( "22","/home/ankur/Downloads/gs-maven-master/complete", "/usr/", "60000");
//		
//		producer.send(facebook);
//		}
//		catch (Exception e) {
//			
//			throw new SendingDataException("Problem sending data");
//		}
//		
		
//		try {
//		// Send Peter customer
//		ProjectInfo peter = new ProjectInfo("spiderman.com", 24);
//		producer.send(peter);
//		}catch (Exception e) {
//			
//			throw new SendingDataException("Problem sending data");
//		}
//	}
}