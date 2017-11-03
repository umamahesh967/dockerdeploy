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

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	UserModel user;
	HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);

	@Before
	public void setUp() throws Exception {
		user = new UserModel("1", "devendra", "dk102@gmail.com","Male","active");
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@After
	public void tearDown() throws Exception {
		ResponseEntity<String> responseNew = restTemplate.exchange(
				createURLWithPort("/v1.0/continousdelivery/user/delete/1"), HttpMethod.DELETE,entity, String.class);
	}

	@Test
	public void testsaveproject() throws Exception {
		HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1.0/continousdelivery/user/add"),
				HttpMethod.POST, entity, String.class);
		assertNotNull(response);
		String actual = response.getBody();
		System.out.println(actual);
		assertEquals("User Added Successfully", actual);
	}

	

	@Test
	public void testupdate() throws Exception {
		HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1.0/continousdelivery/user/add"),
				HttpMethod.POST, entity, String.class);
		UserModel userUpdate = new UserModel("1", "devd", "dk102@gmail.com","Male","inactive");
		HttpEntity<UserModel> entityNew = new HttpEntity<UserModel>(userUpdate, headers);
		ResponseEntity<String> responseNew = restTemplate.exchange(
				createURLWithPort("/v1.0/continousdelivery/user/update"), HttpMethod.PUT, entityNew, String.class);
		assertNotNull(responseNew);
		String actual = responseNew.getBody();
		System.out.println(actual);
		assertEquals("User Updated Successfully", actual);
	}
	
	@Test
	public void testdelete() throws Exception {
		HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/v1.0/continousdelivery/user/add"),
				HttpMethod.POST, entity, String.class);
		ResponseEntity<String> responseNew = restTemplate.exchange(
				createURLWithPort("/v1.0/continousdelivery/user/delete/1"), HttpMethod.DELETE,entity, String.class);
		assertNotNull(responseNew);
		String actual = responseNew.getBody();
		System.out.println(actual);
		assertEquals("User with Id 1 Deleted Succesfully", actual);
	}

}