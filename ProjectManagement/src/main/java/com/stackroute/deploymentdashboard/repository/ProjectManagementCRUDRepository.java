package com.stackroute.deploymentdashboard.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.*;

import com.stackroute.deploymentdashboard.domains.*;

/*
 * 
 * CRUD operations to be performed on Project extended in interface
 * */

@Transactional
public interface ProjectManagementCRUDRepository extends MongoRepository<ProjectManagementObject, String>{
	
	ProjectManagementObject findByProjectId(String projectId);

	


}

