package com.stackroute.workflowengineservice.exception;

public class InternalUnixCommandException extends Exception{
//	static final long serialVersionUID = 42L;
	
	private String errormessage;
	
	public InternalUnixCommandException(String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}

	public InternalUnixCommandException() {
		// TODO Auto-generated constructor stub
	}

	public String getErrormessage() {
		return errormessage;
	}
}
