package com.Project.Management.Exceptions;



public class UrlNotRepositoryException extends Exception {
	static final long serialVersionUID = 43L;
	
	private String errorDescription;
	
	public UrlNotRepositoryException(String errorDescription) {
		super(errorDescription);
		this.errorDescription = errorDescription;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
}
