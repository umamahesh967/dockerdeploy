package com.stackroute.deploymentdashboard.service;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import java.lang.annotation.Repeatable;

import org.springframework.mail.SimpleMailMessage;
import com.stackroute.deploymentdashboard.model.EmailCredentials;




@Service
public class MailingServiceImpl {

@Autowired
MailSender mailSender;
	
	EmailCredentials emailCredentials=new EmailCredentials();
	
	public void put(EmailCredentials report) {
		
		emailCredentials=report;
		}
	
	
    public String sendmail(String trigger) {
    	SimpleMailMessage message = new SimpleMailMessage();
      
    	
		message.setText(emailCredentials.getBuildStatus());
  
    	message.setText("build status will show");

    	message.setTo("saicharanpardhu@gmail.com ");
    	message.setFrom(" dashboard.stackroute@gmail.com");
	  try {
	      mailSender.send(message);
	      return "{\"message\": \"OK\"}";
	  } catch (Exception e) {
	      e.printStackTrace();
	      return "{\"message\": \"Error\"}";
	  }
			
		}

}
	
	
//	public String Createmail() {
//	 SimpleMailMessage message = new SimpleMailMessage();
//     
//   message.setText(report.getBuildStatus());
//   
////	 message.setText("build status will show");
//
//   message.setTo("saicharanpardhu@gmail.com ");
//   message.setFrom(" dashboard.stackroute@gmail.com");
//   try {
//       mailSender.send(message);
//       return "{\"message\": \"OK\"}";
//   } catch (Exception e) {
//       e.printStackTrace();
//       return "{\"message\": \"Error\"}";
//   }
//}	

