package com.stackroute.application.model;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class HtmlModelTest {

	
	@Test
	public void testProjectId() {
		HtmlModel HtmlModel = new HtmlModel();
		
		HtmlModel.setPid("12345");
		String actual = HtmlModel.getPid();
		
		assertNotNull(actual);
		assertEquals("12345", actual);
	}
	
	
	@Test
	public void testUserId() {
		HtmlModel HtmlModel = new HtmlModel();
		
		HtmlModel.setUid("user123");
		String actual = HtmlModel.getUid();
		
		assertNotNull(actual);
		assertEquals("user123", actual);
	}
	
	@Test
	public void testBuildStatus() {
		HtmlModel HtmlModel = new HtmlModel();
		
		HtmlModel.setbuildStatus("success");
		String actual = HtmlModel.getbuildStatus();
		assertNotNull(actual);
		assertEquals("success", actual);
	}
	

	
}
