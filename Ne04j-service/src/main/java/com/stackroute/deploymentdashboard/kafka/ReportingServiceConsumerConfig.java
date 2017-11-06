package com.stackroute.deploymentdashboard.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import com.stackroute.deploymentdashboard.model.ProjectModel;
import com.stackroute.deploymentdashboard.model.UserModel;

@EnableKafka
@Configuration
public class ReportingServiceConsumerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;
	
	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	@Bean
	    public ConsumerFactory<String, String> consumerFactory() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(
	          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
	          bootstrapAddress);
	        props.put(
	          ConsumerConfig.GROUP_ID_CONFIG, 
	          groupId);
	        props.put(
	          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
	          StringDeserializer.class);
	        props.put(
	          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
	          StringSerializer.class);
	        return new DefaultKafkaConsumerFactory<>(props
										        		,new StringDeserializer(),
										        		new StringDeserializer()
										        		);
	    }
	
	 
	    @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, String> 
	      kafkaListenerContainerFactory() {
	    
	        ConcurrentKafkaListenerContainerFactory<String, String> factory
	          = new ConcurrentKafkaListenerContainerFactory<>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
	    
	    
	    
	    
	    @Bean
	    public ConsumerFactory<String, ProjectModel> ProjectModelconsumerFactory() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(
	          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
	          bootstrapAddress);
	        
	        props.put(
	          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
	          StringDeserializer.class);
	        props.put(
	          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
	          JsonDeserializer.class);
	        props.put(
	                ConsumerConfig.GROUP_ID_CONFIG, 
	                groupId);
	        return new DefaultKafkaConsumerFactory<>(
	        	      props,
	        	      new StringDeserializer(), 
	        	      new JsonDeserializer<>(ProjectModel.class));
	    }
	 
		@Bean
		public ConcurrentKafkaListenerContainerFactory<String, ProjectModel> 
		  projectModelKafkaListenerContainerFactory() {
		 
		    ConcurrentKafkaListenerContainerFactory<String, ProjectModel> factory
		      = new ConcurrentKafkaListenerContainerFactory<>();
		    factory.setConsumerFactory(ProjectModelconsumerFactory());
		    return factory;
		}
		
		
		
		@Bean
	    public ConsumerFactory<String, UserModel> UserModelconsumerFactory() {
	        Map<String, Object> props = new HashMap<>();
	        props.put(
	          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
	          bootstrapAddress);
	        
	        props.put(
	          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
	          StringDeserializer.class);
	        props.put(
	          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
	          JsonDeserializer.class);
	        props.put(
	                ConsumerConfig.GROUP_ID_CONFIG, 
	                groupId);
	        return new DefaultKafkaConsumerFactory<>(
	        	      props,
	        	      new StringDeserializer(), 
	        	      new JsonDeserializer<>(UserModel.class));
	    }
	 
		@Bean
		public ConcurrentKafkaListenerContainerFactory<String, UserModel> 
		  userModelKafkaListenerContainerFactory() {
		 
		    ConcurrentKafkaListenerContainerFactory<String, UserModel> factory
		      = new ConcurrentKafkaListenerContainerFactory<>();
		    factory.setConsumerFactory(UserModelconsumerFactory());
		    return factory;
		}
		
		

}
