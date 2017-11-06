package com.stackroute.deploymentdashboard.controller;





import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
    String project1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    ProjectManagementObject projectManagementObject;
    @Before
    public void setUp() throws Exception {
         projectManagementObject = new ProjectManagementObject("mail","goutham",null);
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveProject() throws Exception {
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
    public void testdelete() throws Exception {
        HttpEntity<ProjectManagementObject> entity = new HttpEntity<ProjectManagementObject>(projectManagementObject, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Project/delete/3"),
                HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Deleted succesfully",actual);
    }  
   @Test
    public void testupdate() throws Exception {
        HttpEntity<ProjectManagementObject> entity = new HttpEntity<ProjectManagementObject>(projectManagementObject, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Project/updateproject"),
                HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Project updated successfully",actual);
    }
    
   
   @Test
    public void testEGetProjectByExistingId() throws Exception {
        HttpEntity<ProjectManagementObject> entity = new HttpEntity<ProjectManagementObject>(projectManagementObject, headers);
        ResponseEntity<ProjectManagementObject> response = restTemplate.exchange(
                createURLWithPort("/Project/show/3"),
                HttpMethod.GET, entity, ProjectManagementObject.class);
        
      assertNotNull("Expected some value but found null",response);
        assertEquals("Status code is not as expected",HttpStatus.OK,response.getStatusCode());      
   }
  
    
   

}