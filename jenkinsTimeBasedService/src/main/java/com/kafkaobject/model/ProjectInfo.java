package com.kafkaobject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectInfo {
	@NotNull(message="project url cannot be null")
	private String url;
//	@NotNull(message="project id cannot be null")
	@Min(1)
//	@Size(@Min(1))
//	@NotEmpty(message="project id cannot be null")
	private int id;
	
	public ProjectInfo(){
	}
	
	public ProjectInfo(String url, int id){
		this.url = url;
		this.id = id;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	public void setId(int age){
		this.id = age;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String toString(){
		String info = String.format("{ 'url': %s, 'age': %d}", url, id);
		return info;
	}
}