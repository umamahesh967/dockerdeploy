package com.stackroute.deploymentdashboard.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.deploymentdashboard.model.ProjectModel;
import com.stackroute.deploymentdashboard.model.UserModel;


@Repository
public interface UserRepository extends Neo4jRepository<UserModel, Long>{

}
