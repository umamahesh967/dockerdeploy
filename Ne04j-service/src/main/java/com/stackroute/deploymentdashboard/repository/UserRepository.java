package com.stackroute.deploymentdashboard.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.deploymentdashboard.model.ProjectModel;
import com.stackroute.deploymentdashboard.model.UserModel;


@Repository
public interface UserRepository extends Neo4jRepository<UserModel, Long>{

	@Query("MATCH (u:UserModel{userId:{userId}})-[r:WORKS_IN]-(p:ProjectModel) RETURN  p")
	List<ProjectModel> findProjects(@Param(value = "userId") String userId);
	
	@Query("MATCH (u:UserModel{userId:{userId}})-[r:WORKS_IN]-(p) DELETE r,u")
	void deleteUser(@Param(value = "userId") String userId);

}
