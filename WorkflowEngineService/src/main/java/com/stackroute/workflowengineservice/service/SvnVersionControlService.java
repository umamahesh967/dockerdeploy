package com.stackroute.workflowengineservice.service;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;

import com.stackroute.workflowengineservice.exception.JgitInternalException;

public class SvnVersionControlService extends VersionControlService{
// TODO: override the methods
	@Override
	public Git cloning_repo(String repo_url, File cloning_path) throws JgitInternalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void git_commit(Git git, String msg) throws NoHeadException, NoMessageException, UnmergedPathsException,
			ConcurrentRefUpdateException, WrongRepositoryStateException, GitAPIException {
		// TODO Auto-generated method stub
		
	}

}
