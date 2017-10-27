package com.workflow.engine.messenger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.workflow.engine.model.ModelForJenkins;



@Service
public class ReportingServiceProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Value("${kafka.topic.bootnew}")
    String kafkaTopic = "trigger112"; // "${kafka.topic.bootnew}";
    
    public void send(String model) {
        System.out.println("sending data=" + model);
        System.out.println(kafkaTopic);
        kafkaTemplate.send(kafkaTopic, "he.llloo");
        System.out.println("sending done ...........yooooooooooooo" );
    }
}

//package com.workflow.engine.messenger;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.kafka.core.KafkaTemplate;
//
//
//@Service
//public class ReportingServiceProducer {
//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//	 
//	public void sendMessage(String report) {
//	    kafkaTemplate.send("testrun4", report);
//	}
//}
