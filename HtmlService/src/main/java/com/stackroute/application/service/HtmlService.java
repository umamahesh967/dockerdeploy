package com.stackroute.application.service;

import org.springframework.stereotype.Component;

import com.stackroute.application.model.HtmlModel;

@Component
public class HtmlService {
   
	HtmlModel htmlModel=new HtmlModel();
	public void put(HtmlModel report) {
	
		this.htmlModel=report;
		sendHtml();
	}
	private void sendHtml() {
		//here comes the logic to send html
		
	}
	

}
