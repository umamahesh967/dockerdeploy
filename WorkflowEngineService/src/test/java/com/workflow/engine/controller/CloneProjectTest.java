package com.workflow.engine.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.workflow.engine.exception.InternalUnixCommandException;

public class CloneProjectTest {

	private static CloneProject cp;

	@Before
	public void init(){
		cp = new CloneProject();
	}
/*	
	@Test
	public void runUnixCommandTest() throws InternalUnixCommandException {
		assertNotNull("runUnixCommand must be true.",
				cp.runUnixCommand("pwd"));
		assertTrue(cp.runUnixCommand("pwd"));
	}
*/
}
