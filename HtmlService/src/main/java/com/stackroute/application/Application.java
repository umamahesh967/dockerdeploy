package com.stackroute.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.tmatesoft.svn.core.SVNException;

@SpringBootApplication
//@EnableDiscoveryClient
public class Application {	
	public static void main(String[] args) throws SVNException {
		SpringApplication.run(Application.class, args);
	}
}
