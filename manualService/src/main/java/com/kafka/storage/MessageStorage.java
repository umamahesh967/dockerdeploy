package com.kafka.storage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.kafka.model.Model;
 
@Component
public class MessageStorage {
	
	private List<Model> storage = new ArrayList<Model>();
	
	public void put(Model message){
		storage.add(message);
	}
	
//	public String toString(){
//		StringBuffer info = new StringBuffer();
//		storage.forEach(msg->info.append(msg).append("<br/>"));
//		return info.toString();
//	}
	
	
//	public void clear(){
//		storage.clear();
//	}

	public List<Model> get() {
		// TODO Auto-generated method stub
		return  storage;
	}
}
