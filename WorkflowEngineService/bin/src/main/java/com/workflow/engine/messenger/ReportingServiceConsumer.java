package com.workflow.engine.messenger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.workflow.engine.model.ModelForJenkins;
 
@Service
public class ReportingServiceConsumer {
	
	@KafkaListener(topics="${kafka.topic.bootnew}")
    public void processMessage(ModelForJenkins model) {
		System.out.println("received content = " + model);
    }
}

/*import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class ReportingServiceConsumer {
	
	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
	    return latch;
	}
	
	
	@KafkaListener(topics = "testrun4", containerFactory = "reportKafkaListenerContainerFactory")
	public void reportlistener(String report) {
	    latch.countDown();
	}
}*/