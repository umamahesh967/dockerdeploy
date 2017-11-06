package com.stackroute.deploymentdashboard.controller;

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

import com.stackroute.deploymentdashboard.Application;
import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectManagementControllerTest {
    
    @LocalServerPort
    private int port;
    
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    ProjectManagementObject projectManagementObject;
    
	HttpEntity<ProjectManagementObject> entity = new HttpEntity<ProjectManagementObject>(projectManagementObject, headers);

    
    @Before
    public void setUp() throws Exception {
//         projectManagementObject = new ProjectManagementObject("project2.2","project2","mail.com");
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
    
    @After
    public void tearDown() throws Exception {
   	ResponseEntity<String> responseNew = restTemplate.exchange(
				createURLWithPort("Project/delete/project2.0"), HttpMethod.DELETE, entity, String.class);
	}
    
    
    
    @Test
    public void testSaveProject() throws Exception {
    	 projectManagementObject = new ProjectManagementObject("project1.9","project2","mail.com");
        HttpEntity<ProjectManagementObject> entity = new HttpEntity<ProjectManagementObject>(projectManagementObject, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Project/addproject"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Project added successfully",actual);
    }

    
   @Test
    public void testupdate() throws Exception {
  	 projectManagementObject = new ProjectManagementObject("project1.9","project2","mail.com");

	   HttpEntity<ProjectManagementObject> entity = new HttpEntity<ProjectManagementObject>(projectManagementObject, headers);
       ResponseEntity<String> response = restTemplate.exchange(
               createURLWithPort("/Project/addproject"),
               HttpMethod.POST, entity, String.class);
       
       ProjectManagementObject projectManagementObjectnew = new ProjectManagementObject("project1.9","project2.2","mail.com");

       
        HttpEntity<ProjectManagementObject> entitynew = new HttpEntity<ProjectManagementObject>(projectManagementObjectnew, headers);
        ResponseEntity<String> responsenew = restTemplate.exchange(
                createURLWithPort("/Project/updateproject"),
                HttpMethod.PUT, entity, String.class);
        assertNotNull(responsenew);
        String actual = responsenew.getBody();
        System.out.println(actual);
        assertEquals("Project updated successfully",actual);
    }
    
   

   @Test
   public void testdelete() throws Exception {
  	 projectManagementObject = new ProjectManagementObject("project1.9","project2","mail.com");

	   HttpEntity<ProjectManagementObject> entity = new HttpEntity<ProjectManagementObject>(projectManagementObject, headers);
       ResponseEntity<String> response = restTemplate.exchange(
               createURLWithPort("/Project/addproject"),
               HttpMethod.POST, entity, String.class);
       
       ResponseEntity<String> responsenew = restTemplate.exchange(
               createURLWithPort("/Project/delete/project1.9"),
               HttpMethod.DELETE, entity, String.class);
       assertNotNull(responsenew);
       String actual = responsenew.getBody();
       System.out.println(actual);
       assertEquals("Deleted succesfully",actual);
   }
   

}