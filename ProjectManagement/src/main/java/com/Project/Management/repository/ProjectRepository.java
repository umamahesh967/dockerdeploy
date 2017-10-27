package com.Project.Management.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.*;
import com.Project.Management.domains.*;

/*
 * 
 * CRUD operations to be performed on Project extended in interface
 * */

@Transactional
public interface ProjectRepository extends MongoRepository<Project, String>{
	
	List<Project>findByProjectId(String projectId);

}

