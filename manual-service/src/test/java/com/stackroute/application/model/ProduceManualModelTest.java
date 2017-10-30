package com.stackroute.application.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ProduceManualModelTest {

	

	@Test
	public void testUrl() {
		ProduceManualModel Model = new ProduceManualModel();
		
		Model.setPid("pid");
		String actual =Model.getPid();
		
		assertNotNull(actual);
		assertEquals("pid", actual);
	}
	@Test
	public void testBuildSuccess() {
		ProduceManualModel Model = new ProduceManualModel();
		
		Model.setBuildSuccess("success");
		String actual =Model.getBuildSuccess();
		
		assertNotNull(actual);
		assertEquals("success", actual);
	}
}
