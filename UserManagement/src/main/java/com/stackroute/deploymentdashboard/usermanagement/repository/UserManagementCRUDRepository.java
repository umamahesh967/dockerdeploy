package com.stackroute.deploymentdashboard.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.transaction.annotation.*;
import com.stackroute.deploymentdashboard.usermanagement.domains.UserModel;

/*
 * 
 * CRUD operations to be performed on Users extended in interface
 * */

//@Transactional
public interface UserManagementCRUDRepository extends MongoRepository<UserModel, String> {

	UserModel findByUserName(String userName);

}
