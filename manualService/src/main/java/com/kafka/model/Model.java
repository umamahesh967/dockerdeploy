package com.kafka.model;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
 
public class Model   {
	@Id
	private String pid;
	private String path;
	
	public String getpid() {
		return pid;
	}
	public void setpid(String pid) {
		this.pid = pid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Model() {
		
	}
     public Model(String pid,String path) {
		this.pid=pid;
		this.path=path;
	}
	
	
	
	

}
