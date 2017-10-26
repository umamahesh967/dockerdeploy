package com.Project.Management.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.Project.Management.domains.Project;
import com.Project.Management.repository.ProjectRepository;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProjectServiceTest {


   private ProjectService projectService;
    @Mock
    private ProjectRepository projectRepository;
    @Mock
    private Project project;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        projectService=new ProjectService();
        projectService.setProjectrepository(projectRepository);
    }
    @Test
    public void shouldReturnProject_whenGetProjectByIdIsCalled() throws Exception {
        // Arrange
        when(projectRepository.findOne("1")).thenReturn(project);
        // Act
        Project retrievedProject = projectService.getByid("1");
        // Assert
        assertThat(retrievedProject, is(equalTo(project)));

  }
    

   @Test
    public void shouldCallDeleteMethodOfProjectRepository_whenDeleteProjectIsCalled() throws Exception {
        // Arrange
        doNothing().when(projectRepository).delete("3");
        ProjectRepository my = Mockito.mock(ProjectRepository.class);
        // Act
        projectService.deleteProject("3");
        // Assert
        verify(projectRepository, times(1)).delete("3");
   }
   
   @Test
   public void shouldUpdateProject_whenUpdateProjectByIdIsCalled() throws Exception {
       // Arrange
       when(projectRepository.save(project)).thenReturn(project);
       // Act
       Project retrievedProject = projectService.updateProject(project);
       // Assert
       assertThat(retrievedProject, is(equalTo(project)));

 }
   
   @Test
   public void shouldCallAddMethodOfProjectRepository_whenAddProjectIsCalled() throws Exception {
       // Arrange
	   when(projectRepository.save(project)).thenReturn(project);
       // Act
       Project retrievedProject = projectService.add(project);
       // Assert
       assertThat(retrievedProject, is(equalTo(project)));
  }
   
   
   
    
}