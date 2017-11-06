package com.stackroute.workflowengineservice.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.stackroute.workflowengineservice.exception.FileGenerationException;
import com.stackroute.workflowengineservice.exception.InternalUnixCommandException;
import com.stackroute.workflowengineservice.exception.JgitInternalException;

public class WorkflowServiceTest {

	WorkflowService workflowService = null;
	GitVersionControlService gitVersionControlService = null;
	
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();
	
	private String FILE_NAME = "temp_file";
	private String FOLDER_NAME = "temp_folder";
	
	File file, folder;
	@Before
	public void setup() throws InternalUnixCommandException {
		 workflowService = new WorkflowService();
		 gitVersionControlService = new GitVersionControlService();
		 
		  file = new File(temp.getRoot(), FILE_NAME);
	      folder = new File(temp.getRoot(), FOLDER_NAME);
	     if(folder.exists()) {
	    	 workflowService.deleteFolder(folder);
	     }
	     
	}
	
	public void checkFilePresent(File file) {
		assertTrue(file.exists());
	}
	
	@Test
	public void createJenkinsFileTest() throws FileGenerationException, IOException {
		HashMap<String,String> cmds = new HashMap<String, String>();
//		cmds.put("build", "build command");
		this.workflowService.createJenkinsFile(file, cmds);
		
		 // Read it from temp file
		BufferedReader br = new BufferedReader(new FileReader(file));
		checkFilePresent(file);
		assertNotNull(br.readLine());
		
	}
	
	@Test
	public void createFileTest() throws FileGenerationException {
		this.workflowService.createFile(file);
		checkFilePresent(file);
	}
	
	@Test
	public void copyJenkinsfileToRepoTest() throws FileGenerationException, IOException {
		this.workflowService.createFile(file);
		this.workflowService.createFile(folder);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write("some content");
		writer.close();
		this.workflowService.copyJenkinsfileToRepo(folder, file);
		
		BufferedReader br = new BufferedReader(new FileReader(folder));
		//System.out.println(br.readLine());
		 //br = new BufferedReader(new FileReader(file));
		 //System.out.println(br.readLine());
		 assertEquals("some content", br.readLine());
		
		//check the content
		
		
	}
	
	@Test
	public void runUnixCommandTest() throws InternalUnixCommandException {
		assertNotNull(this.workflowService.runUnixCommand("pwd"));
	}
	
	@Test
	public void deleteFolderTest() throws FileGenerationException, InternalUnixCommandException {
		this.workflowService.createFile(file);
		this.workflowService.deleteFolder(file);
		assertFalse(file.exists());
	}
	
	@Test
	public void cloing_repoTest() throws JgitInternalException {
		assertFalse(folder.exists());
		assertNull(folder.listFiles());
		this.gitVersionControlService.cloning_repo(
				"https://github.com/Shekharrajak/testmap2", folder);
		assertTrue(folder.exists());
		assertNotNull(folder.listFiles());
	}
	
	@Test
	public void git_commitTest() throws GitAPIException {
		Git git = Git.init().setDirectory(folder).call();
		this.gitVersionControlService.git_commit(git, "this is commit msg");
		Iterable<RevCommit> log = git.log().call();
		Iterator<RevCommit> it = log.iterator();
		
		RevCommit rc = it.next();
		System.out.println(rc.getFullMessage());
		assertEquals("this is commit msg", rc.getFullMessage());
	}
}
