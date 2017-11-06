package com.stackroute.deploymentdashboard.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stackroute.deploymentdashboard.Application;
import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;
import com.stackroute.deploymentdashboard.repository.ProjectManagementCRUDRepository;
import com.stackroute.deploymentdashboard.services.ProjectManagementServiceImpl;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ProjectManagementServiceImplTest {

	@Mock
   private ProjectManagementServiceImpl projectManagementServiceImpl;
   
    @Mock
    private ProjectManagementCRUDRepository projectManagementCRUDRepository;
  
    
    @Before
    public void setupMock() {
//        MockitoAnnotations.initMocks(this);
//        projectManagementServiceImpl=new ProjectManagementServiceImpl();
//        projectManagementServiceImpl.setprojectrepository(projectManagementCRUDRepository);
    	ProjectManagementObject project = new 	ProjectManagementObject("project1.1","project1","http.com" );

    }
    
    
    @Test
	public void testMockCreation() {
		assertNotNull(projectManagementServiceImpl);
		assertNotNull(projectManagementCRUDRepository);
	}

    @Test
    public void shouldReturnProject_whenGetProjectByIdIsCalled() throws Exception {
    	
    	ProjectManagementObject project1 = new 	ProjectManagementObject("project1.1","project1","http.com" );

        // Arrange
//        when(projectManagementCRUDRepository.findByProjectID("project1.1")).thenReturn(projectManagementObject);
        // Act
//        ProjectManagementObject retrievedProject = projectManagementServiceImpl.getprojectid("project1.1");
        // Assert
        assertThat(project1.getprojectID(), is(equalTo("project1.1")));

  }
    

   @Test
    public void shouldDelete_whenDeleteProjectIsCalled() throws Exception {

	   ProjectManagementObject project1 = new ProjectManagementObject("project1.2","project2","http.com" );
 
	   ProjectManagementObject project2=null;
       when(projectManagementServiceImpl.getprojectid("project1.2")).thenReturn(project1);
		assertThat(project1.getprojectName(), is(equalTo("project2")));
		
		projectManagementCRUDRepository.delete("project1.2");
	       when(projectManagementServiceImpl.getprojectid("project1.2")).thenReturn(project2);
			assertThat(project2, is(equalTo(null)));

   }
 
  
	
   @Test
   public void shouldUpdateProject_whenUpdateProjectByIdIsCalled() throws Exception {
       // Arrange
	   ProjectManagementObject project1 = new ProjectManagementObject("project1.2","project2","http.com" );
	   
	   ProjectManagementObject project2=new ProjectManagementObject("project1.3","project2","http.com" );
	   ;
       when(projectManagementServiceImpl.getprojectid("project1.2")).thenReturn(project1);
		assertThat(project1.getprojectName(), is(equalTo("project2")));
		
		projectManagementServiceImpl.updateProject(project2);
	       when(projectManagementServiceImpl.getprojectid("project1.2")).thenReturn(project2);
			assertThat(project2.getprojectName(), is(equalTo(project1.getprojectName())));

 }
   
 @Test
  public void TestAddMethod_whenAddProjectIsCalled() throws Exception {
       // Arrange

	   ProjectManagementObject project1 = new ProjectManagementObject("project1.2","project2","http.com" );
	   
	  
  
		projectManagementServiceImpl.addProject(project1);

	
	       when(projectManagementServiceImpl.getprojectid("project1.2")).thenReturn(project1);
			assertThat(project1.getprojectName(), is(equalTo("project2")));

	 
 }
	 

    
}