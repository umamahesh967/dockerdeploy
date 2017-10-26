package com.Project.Management.controller;





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

import com.Project.Management.Application;
import com.Project.Management.domains.Project;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectControllerTest {
    String project1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    Project project;
    @Before
    public void setUp() throws Exception {
         project = new Project("3","mail","goutham",null, null, null, project1);
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveProject() throws Exception {
        HttpEntity<Project> entity = new HttpEntity<Project>(project, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/Project/addproject"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Project saved successfully",actual);
    }

   @Test
    public void testdelete() throws Exception {
        HttpEntity<Project> entity = new HttpEntity<Project>(project, headers);
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
        HttpEntity<Project> entity = new HttpEntity<Project>(project, headers);
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
        HttpEntity<Project> entity = new HttpEntity<Project>(project, headers);
        ResponseEntity<Project> response = restTemplate.exchange(
                createURLWithPort("/Project/show/3"),
                HttpMethod.GET, entity, Project.class);
        
      assertNotNull("Expected some value but found null",response);
        assertEquals("Status code is not as expected",HttpStatus.OK,response.getStatusCode());      
   }
  
    
   

}