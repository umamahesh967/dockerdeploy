package com.stackroute.workflowengineservice.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.stackroute.workflowengineservice.exception.FileGenerationException;
import com.stackroute.workflowengineservice.exception.InternalUnixCommandException;

public class WorkflowServiceTest {

	WorkflowService workflowService = null;
	
	@Rule
	public TemporaryFolder temp = new TemporaryFolder();
	
	private String FILE_NAME = "temp_file";
	private String FOLDER_NAME = "temp_folder";
	
	File file, folder;
	@Before
	public void setup() throws InternalUnixCommandException {
		 workflowService = new WorkflowService();
		 
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
}
