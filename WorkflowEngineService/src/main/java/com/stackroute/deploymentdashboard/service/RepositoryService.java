package com.stackroute.deploymentdashboard.service;

import com.stackroute.deploymentdashboard.model.JenkinsJob;
import com.workflow.engine.exception.InternalRepositoryException;
import com.workflow.engine.exception.UrlException;

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
