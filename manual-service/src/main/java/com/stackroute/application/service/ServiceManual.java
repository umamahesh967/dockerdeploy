package com.stackroute.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stackroute.application.model.ManualModel;

@Component
public class ServiceManual {
	
private List<ManualModel> storage = new ArrayList<ManualModel>();
	
	public void put(ManualModel message){
		storage.add(message);
	}

	public List<ManualModel> get() {
		// TODO Auto-generated method stub
		return  storage;
	}


}
