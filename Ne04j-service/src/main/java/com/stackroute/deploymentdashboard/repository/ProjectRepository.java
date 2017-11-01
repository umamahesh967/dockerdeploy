package com.stackroute.deploymentdashboard.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.deploymentdashboard.model.ProjectModel;


@Repository
public interface ProjectRepository extends PagingAndSortingRepository<ProjectModel, Long>{

}
