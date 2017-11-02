package com.stackroute.deploymentdashboard.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.deploymentdashboard.model.UserModel;


@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel, Long>{

}
