package com.stackroute.application;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.tmatesoft.svn.core.SVNException;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.stackroute.application.exception.ModelNotFoundException;
import com.stackroute.application.exception.ModelVariableNotFoundException;
import com.stackroute.application.messenger.ReportingServiceProducer;
import com.stackroute.application.model.ManualModel;
import com.stackroute.application.service.ServiceManual;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {	
	public static void main(String[] args)  {
				
			SpringApplication.run(Application.class, args);
		
	

   
	}
	
	

}

