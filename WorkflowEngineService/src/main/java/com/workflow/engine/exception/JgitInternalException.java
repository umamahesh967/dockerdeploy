package com.workflow.engine.exception;

public class JgitInternalException  extends Exception{
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
