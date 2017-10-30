package com.stackroute.application.service;

import org.springframework.stereotype.Component;

import com.stackroute.application.exception.ModelNotFoundException;
import com.stackroute.application.exception.ModelVariableNotFoundException;
import com.stackroute.application.model.HtmlModel;

@Component
public class HtmlService {
   
	HtmlModel htmlModel=new HtmlModel();
	public void put(HtmlModel report) throws ModelNotFoundException, ModelVariableNotFoundException {
	   // checks for exceptions
		if(report==null) throw new ModelNotFoundException("please give some report");
		if(report.getPid()==null) throw new ModelVariableNotFoundException("please give valid project id");
		if(report.getUid()==null) throw new ModelVariableNotFoundException("please give valid user id");
		if(report.getbuildStatus()==null) throw new ModelVariableNotFoundException("build status is missing");
		
		this.htmlModel=report;
		//send sendHtml() sends data to user
		sendHtml();
	}
	
	public HtmlModel getHtmlReport() {
		return htmlModel;
	}
	
	private void sendHtml() {
		//here comes the logic to send html
		
		
		
	}
	

}
