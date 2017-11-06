package com.kafkaobject.kafka.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.scheduling.annotation.Scheduled;

import com.kafkaobject.model.ProjectInfo;
import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.JobWithDetails;

public class JenkinsTrigger {
	private String jobName;

	
	public  void timed(String jobName, String timeStamp){
		  Timer timer = new Timer();
		  int time = Integer.parseInt(timeStamp);
		  int timeSpan = time*60000;
		  
		  TimerTask task = new TimerTask() {
		      @Override
		   public void run() {
		    System.out.println("Inside Timer Task" + System.currentTimeMillis());
		    JenkinsServer jenkins;
			try {
				jenkins = new JenkinsServer(new URI("http://localhost:8080"), "ankur", "Monday123");
				JobWithDetails job= jenkins.getJob(jobName);
		          job.build(true);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       
//		System.out.println(jenkins.getJsobs());
		       }
		  };

		  System.out.println("Current time" + System.currentTimeMillis());
		  timer.schedule(task, timeSpan);
		  System.out.println("Current time" + System.currentTimeMillis());

		  }
	
}
