package com.stackroute.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tmatesoft.svn.core.SVNException;

import com.stackroute.application.messenger.ReportingServiceProducer;
import com.stackroute.application.model.ManualModel;

@SpringBootApplication
public class Application implements CommandLineRunner{	
	public static void main(String[] args) throws SVNException {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	ReportingServiceProducer producer;
	
	@Override
    public void run(String... arg0) throws Exception {
        try {
        // Send fb customer
        ManualModel facebook = new ManualModel();
        facebook.setPath("asc");
        facebook.setPid("lolololol");
        facebook.setUrl("asdsd");
        producer.sendMessage(facebook);
        }
        catch (Exception e) {
            
            
        }
        
    }
}
