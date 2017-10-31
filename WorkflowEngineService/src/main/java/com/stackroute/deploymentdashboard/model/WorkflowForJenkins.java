package com.stackroute.deploymentdashboard.model;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize 
public class WorkflowForJenkins {

	private List<String> cmds;

	/**
	 * @param cmds
	 */
	public WorkflowForJenkins(List<String> list_cmd) {
		super();
		this.cmds = list_cmd;
	}

	/**
	 * 
	 */
	public WorkflowForJenkins() {
		super();
	}

	public List<String> getCmds() {
		return cmds;
	}

	public void setCmds(List<String> cmds) {
		this.cmds = cmds;
	}
}
