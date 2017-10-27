//package com.kafkaobject.kafka.consumer;
////package com.kafkaobject.kafka.consumer;
////
////
////import static org.assertj.core.api.Assertions.assertThat;
////
////import java.util.HashMap;
////import java.util.Map;
////import java.util.concurrent.TimeUnit;
////
////import org.apache.kafka.clients.consumer.ConsumerRecord;
////import org.apache.kafka.clients.consumer.MockConsumer;
////import org.junit.Before;
////import org.junit.ClassRule;
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
////import org.springframework.kafka.core.DefaultKafkaProducerFactory;
////import org.springframework.kafka.core.KafkaTemplate;
////import org.springframework.kafka.core.ProducerFactory;
////import org.springframework.kafka.listener.MessageListenerContainer;
////import org.springframework.kafka.test.rule.KafkaEmbedded;
////import org.springframework.kafka.test.utils.ContainerTestUtils;
////import org.springframework.kafka.test.utils.KafkaTestUtils;
////import org.springframework.test.annotation.DirtiesContext;
////
////import kafka.consumer.*;
////import kafka.javaapi.consumer.ConsumerConnector;
////import kafka.message.MessageAndMetadata;
////import kafka.serializer.StringDecoder;
////import kafka.server.KafkaConfig;
////import kafka.server.KafkaServerStartable;
////import org.apache.curator.test.TestingServer;
////import org.apache.kafka.clients.producer.KafkaProducer;
////import org.apache.kafka.clients.producer.Producer;
////import org.apache.kafka.clients.producer.ProducerRecord;
////import org.junit.After;
////import org.junit.Before;
////import org.junit.Test;
////
////import java.io.IOException;
////import java.util.HashMap;
////import java.util.List;
////import java.util.Map;
////import java.util.Properties;
////
////import static org.hamcrest.core.Is.is;
////import static org.junit.Assert.assertThat;
////import org.springframework.test.context.junit4.SpringRunner;
////
////import com.kafkaobject.model.ProjectInfo;
////
////@RunWith(SpringRunner.class)
////@SpringBootTest
////@DirtiesContext
////
//////
//////  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerTest.class);
//////
//////  private static String RECEIVER_TOPIC = "jsa-test";
//////
//////  @Autowired
//////  private KafkaConsumer receiver;
//////
//////  private KafkaTemplate<String, ProjectInfo> template;
//////
//////  @Autowired
//////  private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//////
//////  @ClassRule
//////  public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(2, true, RECEIVER_TOPIC);
////
////	public class KafkaMostBasicTest {
////	    public final static String topic = "topic1-" + System.currentTimeMillis();
////
////	    private KafkaTestFixture server;
////	    private Producer producer;
////	    private ConsumerConnector consumerConnector;
////
////	    @Before
////	    public void setup() throws Exception {
////	        server = new KafkaTestFixture();
////	        server.start(serverProperties());
////	    }
////
////	    @After
////	    public void teardown() throws Exception {
////	        producer.close();
////	        consumerConnector.shutdown();
////	        server.stop();
////	    }
////
////	    @Test
////	    public void shouldWriteThenRead() throws Exception {
////
////	        //Create a consumer
////	        ConsumerIterator<String, String> it = buildConsumer(KafkaMostBasicTest.topic);
////
////	        //Create a producer
////	        producer = new KafkaProducer(producerProps());
////
////	        //send a message
////	        producer.send(new ProducerRecord(KafkaMostBasicTest.topic, "message")).get();
////
////	        //read it back
////	        MessageAndMetadata<String, String> messageAndMetadata = it.next();
////	        String value = messageAndMetadata.message();
////	        assertThat(value, is("message"));
////	    }
////
////	    private ConsumerIterator<String, String> buildConsumer(String topic) {
////	        Properties props = consumerProperties();
////
////	        Map<String, Integer> topicCountMap = new HashMap();
////	        topicCountMap.put(topic, 1);
////	        ConsumerConfig consumerConfig = new ConsumerConfig(props);
////	        consumerConnector = Consumer.createJavaConsumerConnector(consumerConfig);
////	        Map<String, List<KafkaStream<String, String>>> consumers = consumerConnector.createMessageStreams(topicCountMap, new StringDecoder(null), new StringDecoder(null));
////	        KafkaStream<String, String> stream = consumers.get(topic).get(0);
////	        return stream.iterator();
////	    }
////
////	    private Properties consumerProperties() {
////	        Properties props = new Properties();
////	        props.put("zookeeper.connect", serverProperties().get("zookeeper.connect"));
////	        props.put("group.id", "group1");
////	        props.put("auto.offset.reset", "smallest");
////	        return props;
////	    }
////
////	    private Properties producerProps() {
////	        Properties props = new Properties();
////	        props.put("bootstrap.servers", "localhost:9092");
////	        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
////	        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
////	        props.put("request.required.acks", "1");
////	        return props;
////	    }
////
////	    private Properties serverProperties() {
////	        Properties props = new Properties();
////	        props.put("zookeeper.connect", "localhost:2181");
////	        props.put("broker.id", "1");
////	        return props;
////	    }
////
////	    private static class KafkaTestFixture {
////	        private TestingServer zk;
////	        private KafkaServerStartable kafka;
////
////	        public void start(Properties properties) throws Exception {
////	            Integer port = getZkPort(properties);
////	            zk = new TestingServer(port);
////	            zk.start();
////
////	            KafkaConfig kafkaConfig = new KafkaConfig(properties);
////	            kafka = new KafkaServerStartable(kafkaConfig);
////	            kafka.startup();
////	        }
////
////	        public void stop() throws IOException {
////	            kafka.shutdown();
////	            zk.stop();
////	            zk.close();
////	        }
////
////	        private int getZkPort(Properties properties) {
////	            String url = (String) properties.get("zookeeper.connect");
////	            String port = url.split(":")[1];
////	            return Integer.valueOf(port);
////	        }
////	    }
////	}
////}
//
//
//import static org.assertj.core.api.Assertions.assertThat;
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
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.listener.MessageListenerContainer;
//import org.springframework.kafka.test.rule.KafkaEmbedded;
//import org.springframework.kafka.test.utils.ContainerTestUtils;
//import org.springframework.kafka.test.utils.KafkaTestUtils;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@DirtiesContext
//public class SpringKafkaReceiverTest {
//
//  private static final Logger LOGGER = LoggerFactory.getLogger(SpringKafkaReceiverTest.class);
//
//  private static String RECEIVER_TOPIC = "receiver.t";
//
//  @Autowired
//  private Receiver receiver;
//
//  private KafkaTemplate<String, String> template;
//
//  @Autowired
//  private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
//
//  @ClassRule
//  public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, RECEIVER_TOPIC);
//
//  @Before
//  public void setUp() throws Exception {
//    // set up the Kafka producer properties
//    Map<String, Object> senderProperties =
//        KafkaTestUtils.senderProps(embeddedKafka.getBrokersAsString());
//
//    // create a Kafka producer factory
//    ProducerFactory<String, String> producerFactory =
//        new DefaultKafkaProducerFactory<String, String>(senderProperties);
//
//    // create a Kafka template
//    template = new KafkaTemplate<>(producerFactory);
//    // set the default topic to send to
//    template.setDefaultTopic(RECEIVER_TOPIC);
//
//    // wait until the partitions are assigned
//    for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
//        .getListenerContainers()) {
//      ContainerTestUtils.waitForAssignment(messageListenerContainer,
//          embeddedKafka.getPartitionsPerTopic());
//    }
//  }
//
//  @Test
//  public void testReceive() throws Exception {
//    // send the message
//    String greeting = "Hello Spring Kafka Receiver!";
//    template.sendDefault(greeting);
//    LOGGER.debug("test-sender sent message='{}'", greeting);
//
//    receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//    // check that the message was received
//    assertThat(receiver.getLatch().getCount()).isEqualTo(0);
//  }
//}
package com.kafkaobject.kafka.consumer;
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
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.junit4.SpringRunner;

import com.kafkaobject.kafka.producer.Sender;
import com.kafkaobject.model.ProjectInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringKafkaReceiverTest {
    @Autowired
    private Sender sender;
    @Autowired
    private Receiver receiver;
    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "report-service");
    @Test
    public void testReceive() throws Exception {
        
        ProjectInfo message = new ProjectInfo("ankur",20);
        sender.send("receiver", message); 
        receiver.getLatch().await(3000, TimeUnit.MILLISECONDS);
        assertThat(receiver.getLatch().getCount()).isEqualTo(2);
      }

}
