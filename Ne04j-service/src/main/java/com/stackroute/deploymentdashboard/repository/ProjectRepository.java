package com.stackroute.deploymentdashboard.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.deploymentdashboard.model.ProjectModel;
import com.stackroute.deploymentdashboard.model.UserModel;


@Repository
public interface ProjectRepository extends Neo4jRepository<ProjectModel, Long>{

	@Query("MATCH (u:UserModel)-[r:WORKS_IN]-(p:ProjectModel{projectID:{projectId}}) RETURN  u")
	List<UserModel> findUsers(@Param(value = "projectId") String projectId);
	
	@Query("MATCH (u)-[r:WORKS_IN]-(p:ProjectModel{projectID:{projectId}}) DELETE r,p")
	void deleteProject(@Param(value = "projectId") String projectId);

	@Query("MATCH (u:UserModel{userId:{userId}}),(p:ProjectModel{projectID:{projectId}}) MERGE (u)-[r:WORKS_IN]-(p)")
	void saveLink(String userId, String projectId);

	@Query("MATCH (u:UserModel{userId:{userId}})-[r]-(p:ProjectModel{projectID:{projectId}}) REMOVE r")
	void removeLink(String userId, String projectId);

}
