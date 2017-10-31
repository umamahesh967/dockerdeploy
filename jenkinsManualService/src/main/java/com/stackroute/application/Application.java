package com.stackroute.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.stackroute.application.model.ManualModel;
import com.stackroute.application.service.ServiceManual;



@SpringBootApplication
@EnableDiscoveryClient
public class Application {
	
	@Autowired
	ServiceManual serviceManual; //service
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
}
