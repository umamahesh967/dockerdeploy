package com.stackroute.workflowengineservice.service;

import java.io.File;
import org.springframework.stereotype.Service;

import com.stackroute.workflowengineservice.model.JenkinsJob;
import com.workflow.engine.exception.InternalRepositoryException;
import com.workflow.engine.exception.UrlException;

@Service
public class WorkflowRepositoryServiceImpl implements RepositoryService {
	/*
	checking out a repository to a working directory
	*/
	
	/*
	check local working directory folder validity
	*/
	public boolean checkPathValidity(String folderpath) {
		File dir = new File(folderpath);
		
        // Tests whether the directory denoted by this abstract pathname exists.
		boolean exists = dir.exists();
		
		return exists;
	}




	@Override
	public boolean cloneRepository(JenkinsJob repositorydetails) throws InternalRepositoryException {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean checkUrlValidity(String url) throws UrlException {
		// TODO Auto-generated method stub
		return false;
	}

}
