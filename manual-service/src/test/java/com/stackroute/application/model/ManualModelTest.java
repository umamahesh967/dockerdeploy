package com.stackroute.application.model;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class ManualModelTest {

	@Test
	public void testUrl() {
		ManualModel ManualModel = new ManualModel();
		
		ManualModel.setUrl("www.github.com");
		String actual = ManualModel.getUrl();
		
		assertNotNull(actual);
		assertEquals("www.github.com", actual);
	}
	
	@Test
	public void testPid() {
		ManualModel ManualModel = new ManualModel();
		
		ManualModel.setPid("2149");
		String actual = ManualModel.getPid();
		
		assertNotNull(actual);
		assertEquals("2149", actual);
	}
	
	@Test
	public void testPath() {
		ManualModel ManualModel = new ManualModel();
		
		ManualModel.setPath("path");
		String actual = ManualModel.getPath();
		
		assertNotNull(actual);
		assertEquals("path", actual);
	}
	
	@Test
	public void testSpan() {
		ManualModel ManualModel = new ManualModel();
		
		ManualModel.setTimeSpan(null);
		String actual = ManualModel.getPath();
		
		assertNull(actual);
		assertEquals(null, actual);
	}
	
	
	
	
}
