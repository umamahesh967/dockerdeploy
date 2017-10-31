package com.stackroute.workflowengineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkflowEngineServiceApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(WorkflowEngineServiceApplication.class, args);
	}
}

/*
 * 
 * refer : https://jenkins.io/doc/pipeline/tour/deployment/ for jenkinsFile
 *
 */
