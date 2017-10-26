package com.workflow.engine.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.workflow.engine.controller.CloneProject;
import com.workflow.engine.exception.InternalUnixCommandException;

public class cloneProjectTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	private static CloneProject cp;

	@Before
	public void init(){
		cp = new CloneProject();
	}

	@Test
	public void runUnixCommandTest1() throws InternalUnixCommandException {
		assertNotNull("runUnixCommand must be true.",
				cp.runUnixCommand("pwd"));
		assertTrue(true);
	}
	
	@Test
	public void runUnixCommandTest() throws InternalUnixCommandException {
		assertNotNull("runUnixCommand must be true.",
				cp.runUnixCommand("pwd"));
		assertTrue(cp.runUnixCommand("pwd"));
	}

}
