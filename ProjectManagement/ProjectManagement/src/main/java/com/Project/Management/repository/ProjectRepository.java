package com.Project.Management.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.Project.Management.domains.*;

public interface ProjectRepository extends MongoRepository<Project, String>{
	
	

}

