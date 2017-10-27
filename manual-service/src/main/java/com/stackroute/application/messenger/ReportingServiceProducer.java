package com.stackroute.application.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.application.model.ManualModel;
import com.stackroute.application.service.ServiceManual;

import org.springframework.kafka.core.KafkaTemplate;


@Service
public class ReportingServiceProducer {
	
	@Autowired
	ServiceManual serviceManual;
	
	@Autowired
	private KafkaTemplate<String, ManualModel> kafkaTemplate;
	
	@Value("${spring.kafka.consumer.group-id}")
	private String groupid;
	 
	public void sendMessage(ManualModel report) {
	    kafkaTemplate.send(groupid, report);
	    System.out.println(report);
	}

	public void send(ManualModel manualModel) {
		// TODO Auto-generated method stub
		serviceManual.put(manualModel);
		System.out.println(manualModel);
	}
}
