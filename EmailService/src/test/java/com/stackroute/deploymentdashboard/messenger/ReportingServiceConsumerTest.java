package com.stackroute.deploymentdashboard.messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.stackroute.deploymentdashboard.model.EmailCredentials;
import com.stackroute.deploymentdashboard.service.MailingServiceImpl;

	import static org.junit.Assert.*;
	import org.junit.Test;
	import static org.assertj.core.api.Assertions.assertThat;
	import java.sql.Timestamp;
	import java.util.concurrent.TimeUnit;
	import org.junit.ClassRule;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.test.context.junit4.SpringRunner;
	import org.springframework.kafka.test.rule.KafkaEmbedded;
	import com.stackroute.deploymentdashboard.messenger.*;
	
	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class  ReportingServiceConsumerTest {
	    @Autowired
	    private ReportingServiceProducer sender;
	    @Autowired
	    private ReportingServiceConsumer receiver;
	    @ClassRule
	    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1,true,"ssfcsfvg");
	    @Test
	    public void testReceive() throws Exception {
	        
	       EmailCredentials report = new EmailCredentials("userId","projectId","emailid", "true");
			sender.sendMessage(report); 
	        /*receiver.getLatch().await(3000, TimeUnit.MILLISECONDS);
	        assertThat(receiver.getLatch().getCount()).isEqualTo(2);
	      */
			}
	}