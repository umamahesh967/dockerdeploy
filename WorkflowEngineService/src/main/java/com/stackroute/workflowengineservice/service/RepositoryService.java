package com.stackroute.workflowengineservice.service;

import com.stackroute.workflowengineservice.model.JenkinsJob;
import com.stackroute.workflowengineservice.exception.InternalRepositoryException;
import com.stackroute.workflowengineservice.exception.UrlException;

public interface RepositoryService {
	/*
	clone a project from remote repository to local machine
	*/
	public boolean cloneRepository(JenkinsJob repositorydetails) throws InternalRepositoryException;
	
	
	/*
	check repository url validity
	*/
	public boolean checkUrlValidity(String url) throws UrlException;
	
	
	/*
	check local working directory folder validity
	*/
	public boolean checkPathValidity(String folderpath);
}
