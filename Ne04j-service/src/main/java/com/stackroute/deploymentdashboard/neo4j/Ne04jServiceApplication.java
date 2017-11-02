package com.stackroute.deploymentdashboard.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.stackroute.deploymentdashboard.model")
public class Ne04jServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ne04jServiceApplication.class, args);
	}
}
