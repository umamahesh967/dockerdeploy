package com.workflow.engine.exception;

import org.eclipse.jgit.api.errors.GitAPIException;

public class JgitInternalException  extends GitAPIException{
//	static final long serialVersionUID = 42L;
	
	private String errormessage;
	
	public JgitInternalException(String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}
}
