package com.workflow.engine.exception;

public class UrlException extends Exception {
	static final long serialVersionUID = 43L;
	
	private String errormessage;
	
	public UrlException(String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}
	
	public String getErrormessage() {
		return errormessage;
	}
}
