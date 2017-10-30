package com.stackroute.deploymentdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HtmlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtmlServiceApplication.class, args);
	}
}
