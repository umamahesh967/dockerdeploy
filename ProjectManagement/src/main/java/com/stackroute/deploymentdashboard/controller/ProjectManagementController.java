package com.stackroute.deploymentdashboard.controller;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.deploymentdashboard.Exceptions.CustomExceptionResponse;
import com.stackroute.deploymentdashboard.Exceptions.ProjectnotfoundException;
import com.stackroute.deploymentdashboard.domains.ProjectManagementObject;
import com.stackroute.deploymentdashboard.repository.ProjectManagementCRUDRepository;
import com.stackroute.deploymentdashboard.services.ProjectManagementServiceImpl;

import org.springframework.data.mongodb.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value="/Project")
@Api(value="project", description="Operations pertaining to Projects")
public class ProjectManagementController {
	
	@Autowired
	private ProjectManagementCRUDRepository projectManagementCRUDRepository;
	
	@Autowired
	private ProjectManagementServiceImpl projectservice;
	
	
	@ApiOperation(value = "View a list of available projects",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	
	
	/* request handler for getting list of all projects*/
	@GetMapping(value="/list", produces= {"application/json"})
	public ResponseEntity<?> list() throws ProjectnotfoundException {
		List<ProjectManagementObject> ProjectManagementObject=new ArrayList<>();
		
		ProjectManagementObject=projectservice.getAll();
		
		return new ResponseEntity<List<ProjectManagementObject>>(ProjectManagementObject,HttpStatus.OK);
	
    }
	
    /* request handler for adding a project*/
    
	@PostMapping(value="/addproject",consumes= {"application/json"})
	@ApiOperation(value = "Add a project")
	public ResponseEntity<String> projectadd(@Valid @RequestBody ProjectManagementObject projectManagementObject)throws CustomExceptionResponse{
		
		ProjectManagementObject project_tmp=projectservice.updateProject(projectManagementObject);
		if(project_tmp.equals(projectManagementObject)) {
		return new ResponseEntity<String>("Project saved successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not valid id project",HttpStatus.OK);
		
	}
	
	
	/* request handler for updating a project*/
	@PutMapping(value="/updateproject",consumes= {"application/json"})
	@ApiOperation(value = "Update a project")
	public ResponseEntity<String> projectupdate(@Valid @RequestBody ProjectManagementObject projectManagementObject)throws CustomExceptionResponse{
		ProjectManagementObject project_tmp=projectservice.updateProject(projectManagementObject);
		
		if(project_tmp.equals(projectManagementObject)) {
		return new ResponseEntity<String>("Project updated successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not updated project",HttpStatus.OK);
		
	}
	
	
	/* request handler for showing project by id*/
	@GetMapping(value="/show/{id}", produces= {"application/json"})
	@ApiOperation(value = "Search  project with an ID",response = ProjectManagementObject.class)
	public ResponseEntity<?> getone(@PathVariable("id")  String id)throws ProjectnotfoundException{
		
		ProjectManagementObject projectManagementObject=projectservice.getByid(id);
		
		return new ResponseEntity<ProjectManagementObject>(projectManagementObject,HttpStatus.OK);

		
	}
	
	/* request handler for showing project by projectid*/
	@GetMapping(value="/show/productid/{ProductId}", produces= {"application/json"})
	@ApiOperation(value = "Search  project with an ID",response = ProjectManagementObject.class)
	public ResponseEntity<?> getproductid(@PathVariable  String ProductId)throws ProjectnotfoundException{
		
		List<ProjectManagementObject> projectManagementObject=projectManagementCRUDRepository.findByProjectId(ProductId);
		
		return new ResponseEntity<List<ProjectManagementObject>>(projectManagementObject,HttpStatus.OK);

		
	}
	
	/* request handler for deleting a project by id*/
	
	@ApiOperation(value = "Delete a project")
	@DeleteMapping(value="/delete/{id}", consumes="application/json")
	  public ResponseEntity<String> delete(@PathVariable("id")  String id){
		projectservice.deleteProject(id);
		
		return new ResponseEntity<String>("Deleted succesfully",HttpStatus.OK);
	 
			
    
		}

}
