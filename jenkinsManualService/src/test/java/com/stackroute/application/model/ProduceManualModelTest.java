package com.stackroute.application.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ProduceManualModelTest {

	

	@Test
	public void testUrl() {
		ProduceManualModel Model = new ProduceManualModel();
		
		Model.setProjectID("pid");
		String actual =Model.getProjectID();
		
		assertNotNull(actual);
		assertEquals("pid", actual);
	}
	@Test
	public void testBuildSuccess() {
		ProduceManualModel Model = new ProduceManualModel();
		
		Model.setBuildStatus("success");
		String actual =Model.getBuildStatus();
		
		assertNotNull(actual);
		assertEquals("success", actual);
	}
}
