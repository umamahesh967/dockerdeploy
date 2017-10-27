package com.Project.Management.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;
import com.stackroute.deploymentdashboard.repository.ProjectManagementCRUDRepository;
import com.stackroute.deploymentdashboard.services.ProjectManagementService;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectServiceTest {


   private ProjectManagementService projectManagementService;
    @Mock
    private ProjectManagementCRUDRepository projectManagementCRUDRepository;
    @Mock
    private ProjectManagementObject projectManagementObject;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        projectManagementService=new ProjectManagementService();
        projectManagementService.setProjectrepository(projectManagementCRUDRepository);
    }
    @Test
    public void shouldReturnProject_whenGetProjectByIdIsCalled() throws Exception {
        // Arrange
        when(projectManagementCRUDRepository.findOne("1")).thenReturn(projectManagementObject);
        // Act
        ProjectManagementObject retrievedProject = projectManagementService.getByid("1");
        // Assert
        assertThat(retrievedProject, is(equalTo(projectManagementObject)));

  }
    

   @Test
    public void shouldCallDeleteMethodOfProjectRepository_whenDeleteProjectIsCalled() throws Exception {
        // Arrange
        doNothing().when(projectManagementCRUDRepository).delete("3");
        ProjectManagementCRUDRepository my = Mockito.mock(ProjectManagementCRUDRepository.class);
        // Act
        projectManagementService.deleteProject("3");
        // Assert
        verify(projectManagementCRUDRepository, times(1)).delete("3");
   }
   
   @Test
   public void shouldUpdateProject_whenUpdateProjectByIdIsCalled() throws Exception {
       // Arrange
       when(projectManagementCRUDRepository.save(projectManagementObject)).thenReturn(projectManagementObject);
       // Act
       ProjectManagementObject retrievedProject = projectManagementService.updateProject(projectManagementObject);
       // Assert
       assertThat(retrievedProject, is(equalTo(projectManagementObject)));

 }
   
   @Test
   public void shouldCallAddMethodOfProjectRepository_whenAddProjectIsCalled() throws Exception {
       // Arrange
	   when(projectManagementCRUDRepository.save(projectManagementObject)).thenReturn(projectManagementObject);
       // Act
       ProjectManagementObject retrievedProject = projectManagementService.add(projectManagementObject);
       // Assert
       assertThat(retrievedProject, is(equalTo(projectManagementObject)));
  }
   
   
   
    
}