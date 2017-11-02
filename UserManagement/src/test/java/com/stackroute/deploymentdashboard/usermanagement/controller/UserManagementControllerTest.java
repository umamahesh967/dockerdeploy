package com.stackroute.deploymentdashboard.usermanagement.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.deploymentdashboard.usermanagement.Application;
import com.stackroute.deploymentdashboard.usermanagement.domains.UserModel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserManagementControllerTest {

	String project1;

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	UserModel user;

	@Before
	public void setUp() throws Exception {
		user = new UserModel("1", "devendra", "dk102@gmail.com");
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveProject() throws Exception {
		HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1.0/continousdelivery/user/add"),
				HttpMethod.POST, entity, String.class);
		assertNotNull(response);
		String actual = response.getBody();
		System.out.println(actual);
		assertEquals("User Added Successfully", actual);
	}

	@Test
	public void testdelete() throws Exception {
		HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/v1.0/continousdelivery/user/delete/1"), HttpMethod.DELETE, entity, String.class);
		assertNotNull(response);
		String actual = response.getBody();
		System.out.println(actual);
		assertEquals("User with Id 1 Deleted Succesfully", actual);
	}

	@Test
	public void testupdate() throws Exception {
		HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/v1.0/continousdelivery/user/update"), HttpMethod.PUT, entity, String.class);
		assertNotNull(response);
		String actual = response.getBody();
		System.out.println(actual);
		assertEquals("User Updated Successfully", actual);
	}

}