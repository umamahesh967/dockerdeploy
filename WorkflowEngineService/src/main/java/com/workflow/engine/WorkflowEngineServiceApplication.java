package com.workflow.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
public class WorkflowEngineServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WorkflowEngineServiceApplication.class, args);
	}
}
/*
 * 
 * refere : https://jenkins.io/doc/pipeline/tour/deployment/ for jenkinsFile
 */
