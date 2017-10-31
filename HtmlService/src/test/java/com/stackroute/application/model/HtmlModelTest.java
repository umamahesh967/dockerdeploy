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
		
		HtmlModel.setProjectID("12345");
		String actual = HtmlModel.getProjectID();
		
		assertNotNull(actual);
		assertEquals("12345", actual);
	}
	
	
	
	
	@Test
	public void testBuildStatus() {
		HtmlModel HtmlModel = new HtmlModel();
		
		HtmlModel.setBuildStatus("success");
		String actual = HtmlModel.getBuildStatus();
		assertNotNull(actual);
		assertEquals("success", actual);
	}
	

	
}
