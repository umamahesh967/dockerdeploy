package com.kafka.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.jenkins.trigger.service.JenkinsRule;
import com.kafka.communication.KafkaProducer;
import com.kafka.model.Model;
import com.kafka.storage.MessageStorage;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.BuildCause;
import com.offbytwo.jenkins.model.BuildWithDetails;
 

 
@RestController
@RequestMapping(value="/jsa/kafka")
public class WebRestController {
	
	@Autowired
	KafkaProducer producer;
	
	@Autowired
	MessageStorage storage;
	
//	@Autowired
//	Model model;	
	@PostMapping(value="/data")
	  public @ResponseBody ResponseEntity<Model> postPerson(RequestEntity<Model> request) throws URISyntaxException, IOException  {		
		Model model = request.getBody();
		
		System.out.println(model.getPath()+" vamsi bro "+model.getpid()+" vamsi bro");
		storage.put(model);
		producer.send(model);
//		service.setModel(model);
	    return new ResponseEntity<Model>(model, HttpStatus.OK);
	  }

	
	
	
//	
//	@GetMapping(value="/data")
//	public @ResponseBody String createJob() throws URISyntaxException, IOException{
////		String messages = storage.toString();
////		storage.clear();
//		
////		JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080/jenkins"), "vamsi", "vamsi123");
////		jenkins.createJob("vamsi", "config.xml",true);
////		jenkins.createJob(jobName, jobXml);
//		
//		return "created";
//	}
//	
	
	
	
	
	
	
	@GetMapping(value="/data")
	public @ResponseBody List<Model> getAllRecievedMessage(){
//		String messages = storage.toString();
//		storage.clear();
		List<Model> modelList = new ArrayList<Model>();
		modelList=storage.get();
		
		return modelList;
	}
	
	
	
	
	
	
	

	
	
//	@GetMapping(value="/consumer")
//	public String getAllRecievedMessage(){
//		String messages = storage.toString();
//		storage.clear();
//		
//		return messages;
//	}
}