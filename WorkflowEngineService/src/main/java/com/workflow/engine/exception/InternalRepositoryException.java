package com.workflow.engine.exception;

public class InternalRepositoryException extends Exception {
	static final long serialVersionUID = 42L;
	
	private String errormessage;
	
	public InternalRepositoryException(String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}
}
