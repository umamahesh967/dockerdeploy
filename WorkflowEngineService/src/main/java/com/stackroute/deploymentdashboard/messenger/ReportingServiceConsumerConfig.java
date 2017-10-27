package com.stackroute.deploymentdashboard.messenger;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.deploymentdashboard.model.ModelForJenkins;




@EnableKafka
@Configuration
public class ReportingServiceConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;
    
    @Value("kafka-group")
    private String groupId;
    
    @Bean
    public ConsumerFactory<String, ModelForJenkins> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "something");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<String, ModelForJenkins>(props,new StringDeserializer(), 
                  new JsonDeserializer<>(ModelForJenkins.class));
//        return new DefaultKafkaConsumerFactory<>(props);
    }
    
     
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ModelForJenkins> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ModelForJenkins> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}