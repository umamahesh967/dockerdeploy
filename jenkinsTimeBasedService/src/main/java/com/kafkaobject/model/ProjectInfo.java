package com.kafkaobject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectInfo {
	@NotNull(message="project url cannot be null")
	private String url;
	@NotNull(message="project id cannot be null")
//	@Min(1)
//	@Size(@Min(1))
//	@NotEmpty(message="project id cannot be null")
	private String pid;
	private String path;
	private String timeSpan;
	
	public ProjectInfo(){
	}
	
	public ProjectInfo( String pid, String url,String path, String timespan){
		
		this.pid = pid;
		this.url = url;
		this.path = path;
		this.timeSpan = timespan;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public String getUrl(){
		return this.url;
	}
	
	
	
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTimeSpan() {
		return timeSpan;
	}

	public void setTimeSpan(String timespan) {
		this.timeSpan = timespan;
	}

//	public String toString(){
//		String info = String.format("{ 'pid': %s, 'url': %s, 'path': %s, 'timeSpan': %s}", pid, url,path, timeSpan);
//		return info;
//	}
}