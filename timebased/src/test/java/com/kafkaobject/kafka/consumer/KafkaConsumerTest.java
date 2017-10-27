package com.kafkaobject.kafka.consumer;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.kafkaobject.model.ProjectInfo;
import com.stackroute.virtualassistance.curator.CuratorApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class KafkaConsumerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerTest.class);
    private static String RECEIVER_TOPIC = "receiver.t";
    
    @Autowired
    private KafkaConsumer listener;
    
    private KafkaTemplate<String, ProjectInfo> template;
    
    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
    
    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, RECEIVER_TOPIC);
    
    
    @Before
    public void startup() throws Exception {
        
        // set up the Kafka producer properties
        Map<String, Object> senderProperties =
            KafkaTestUtils.senderProps(embeddedKafka.getBrokersAsString());
        senderProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        senderProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        
        // create a Kafka producer factory
        ProducerFactory<String, ProjectInfo> producerFactory =
            new DefaultKafkaProducerFactory<String, ProjectInfo>(senderProperties);
        // create a Kafka template
        template = new KafkaTemplate<>(producerFactory);
        // set the default topic to send to
        template.setDefaultTopic(RECEIVER_TOPIC);
        // wait until the partitions are assigned
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
            .getListenerContainers()) {
          ContainerTestUtils.waitForAssignment(messageListenerContainer,
              embeddedKafka.getPartitionsPerTopic());
        }
        
        
    }
    
    @After
    public void teardown() {
        
        
    }
    
    
    @Test
      public void testReceive() throws Exception {
        // send the message
    	ProjectInfo rb = new ProjectInfo();
        rb.setUrl("www.github.com");
        rb.setId(20);
        template.sendDefault(rb);
        
        LOGGER.debug("test-sender sent message='{}'", rb);
        
        LOGGER.debug("{}", listener.hashCode());
        listener.getLatch().await(5000, TimeUnit.MILLISECONDS);
        
        // check that the message was received
        assertThat(listener.getLatch().getCount()).isEqualTo(0);
        
        
      }
}