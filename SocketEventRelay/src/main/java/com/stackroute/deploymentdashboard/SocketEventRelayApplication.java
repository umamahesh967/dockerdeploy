package com.stackroute.deploymentdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SocketEventRelayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocketEventRelayApplication.class, args);
	}
}
