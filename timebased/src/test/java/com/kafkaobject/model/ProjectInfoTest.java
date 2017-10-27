package com.kafkaobject.model;


import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

public class ProjectInfoTest {

	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@Test
	public void testUrl() {
		ProjectInfo projectinfo = new ProjectInfo();
		
		projectinfo.setUrl("www.google.com");
		String actual = projectinfo.getUrl();
		
		assertNotNull(actual);
		assertEquals("www.google.com", actual);
	}
	
	@Test
	public void testId() {
		ProjectInfo repositorydetails = new ProjectInfo();
		
		repositorydetails.setId(27);
		int actual = repositorydetails.getId();
		
		assertNotNull(actual);
		assertEquals(27, actual);
	}
	
	
	@Test
	public void testUrlNull() {
		String actual = null;
		ProjectInfo repositorydetails = new ProjectInfo();
		
		repositorydetails.setUrl(null);
		repositorydetails.setId(27);
		Set<ConstraintViolation<ProjectInfo>> violations = validator.validate(repositorydetails);
		for(ConstraintViolation<ProjectInfo> violation : violations) {
			actual = violation.getMessage();
			System.err.println(actual);
		}
		
		assertEquals("project url cannot be null", actual);
	}
	
	
	@Test
	public void testIdNull() {
		String actual = null;
		ProjectInfo repositorydetails = new ProjectInfo();
		
		repositorydetails.setUrl("www.github.com");
		repositorydetails.setId(0);
		Set<ConstraintViolation<ProjectInfo>> violations = validator.validate(repositorydetails);
		for(ConstraintViolation<ProjectInfo> violation : violations) {
			actual = violation.getMessage();
		}
		
		assertEquals("must be greater than or equal to 1", actual);
	}
}

