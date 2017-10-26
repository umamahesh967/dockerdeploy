package com.workflow.engine.service;

import com.workflow.engine.exception.InternalRepositoryException;
import com.workflow.engine.exception.UrlNotRepositoryException;
import com.workflow.engine.model.ModelForJenkins;

public interface RepositoryService {
	/*
	clone a project from remote repository to local machine
	*/
	public boolean cloneRepository(ModelForJenkins repositorydetails) throws InternalRepositoryException;
	
	
	/*
	check repository url validity
	*/
	public boolean checkUrlValidity(String url) throws UrlNotRepositoryException;
	
	
	/*
	check local working directory folder validity
	*/
	public boolean checkPathValidity(String folderpath);
}
