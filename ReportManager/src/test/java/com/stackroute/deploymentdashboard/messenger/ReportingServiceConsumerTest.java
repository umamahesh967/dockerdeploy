//package com.stackroute.deploymentdashboard.messenger;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;
//
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Before;
//import org.junit.ClassRule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.listener.MessageListenerContainer;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.kafka.test.rule.KafkaEmbedded;
//import org.springframework.kafka.test.utils.ContainerTestUtils;
//import org.springframework.kafka.test.utils.KafkaTestUtils;
//
//
//import com.stackroute.deploymentdashboard.model.UserCredentials;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DirtiesContext
////@ContextConfiguration(locations = "classpath:application.properties")
////@PropertySource(value = { "application.properties" })
////@TestPropertySource(properties = { "spring.kafka.consumer.group-id=logdata", "spring.kafka.bootstrap-servers=192.168.43.35:9092" })
//public class ReportingServiceConsumerTest {
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(ReportingServiceConsumerTest.class);
//
//	private static String RECEIVER_TOPIC = "logdata";
//
//	@Autowired
//	private ReportingServiceConsumer reportingServiceConsumer;
//	
//	
//	private KafkaTemplate<String, UserCredentials> template;
//	
//	@Autowired
//	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//
//	@ClassRule
//	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, RECEIVER_TOPIC);
//	
//	
//
//	@Before
//	public void setUp() throws Exception {
//		
//		 // set up the Kafka producer properties
//	    Map<String, Object> senderProperties =
//	    KafkaTestUtils.senderProps(embeddedKafka.getBrokersAsString());
//
//	 // create a Kafka producer factory
//	    ProducerFactory<String, UserCredentials> producerFactory =
//	    new DefaultKafkaProducerFactory<String, UserCredentials>(senderProperties);
//
//	 // create a Kafka template
//	    template = new KafkaTemplate<>(producerFactory);
//	    // set the default topic to send to
//	    template.setDefaultTopic(RECEIVER_TOPIC);
//
//	 // wait until the partitions are assigned
//	    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
//	        .getListenerContainers()) {
//	      ContainerTestUtils.waitForAssignment(messageListenerContainer,
//	          embeddedKafka.getPartitionsPerTopic());
//	    }
//	    
//	}
//	
//	@Test
//	public void testReceive() throws Exception {
//	    // send the message
//	    UserCredentials usercredentials=new UserCredentials("test","results");
//	    template.sendDefault(usercredentials);
//	    LOGGER.debug("test-sender sent message='{}'", usercredentials);
//
//	    reportingServiceConsumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
//	    // check that the message was received
//	    assertThat(reportingServiceConsumer.getLatch().getCount()).isEqualTo(0);
//	}
//
//	
//	
//
//}
