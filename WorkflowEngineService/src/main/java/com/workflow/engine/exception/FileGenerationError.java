package com.workflow.engine.exception;

public class FileGenerationError extends Exception{
//	static final long serialVersionUID = 42L;
	
	private String errormessage;
	
	public FileGenerationError(String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}
}
