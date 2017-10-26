package com.kafkaobject.exception;

public class SendingDataException extends Exception {
	static final long serialVersionUID = 42L;
	
	private String errormessage;
	
	public SendingDataException(String errormessage) {
		super(errormessage);
		this.errormessage = errormessage;
	}

	public String getErrormessage() {
		return errormessage;
	}
}
