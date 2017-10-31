package com.stackroute.workflowengineservice.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
 * Workflow engine will recv  the data in this object.
 * */
@JsonDeserialize
public class WorksetupJob {

	private String url;
	private String pid;
	private String timespan;
	private List<String> list_cmd;

	public String getUrl() {
		return url;
	}
	public List<String> getList_cmd() {
		return list_cmd;
	}
	public void setList_cmd(List<String> list_cmd) {
		this.list_cmd = list_cmd;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTimespan() {
		return timespan;
	}
	/**
	 * @param url
	 * @param pid
	 * @param timespan
	 */
	public WorksetupJob(String url, String pid, String timespan) {
		super();
		this.url = url;
		this.pid = pid;
		this.timespan = timespan;
	}
	/**
	 * 
	 */
	public WorksetupJob() {
		super();
	}
	public void setTimespan(String timespan) {
		this.timespan = timespan;
	}

}
