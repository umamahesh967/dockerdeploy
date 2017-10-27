
package com.Project.Management.Exceptions;

public class CustomExceptionResponse extends Exception {
    private String errorDescription;
    private String error;
	
	public String getErrorMessage() {
		return errorDescription;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorDescription = errorMessage;
	}
	
	public String getErrors() {
		return error;
	}
	public void setErrors(String error) {
		this.error = error;
	}
}
