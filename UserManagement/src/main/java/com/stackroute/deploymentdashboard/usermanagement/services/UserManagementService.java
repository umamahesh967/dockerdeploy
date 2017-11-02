package com.stackroute.deploymentdashboard.usermanagement.services;

import java.util.List;

import com.stackroute.deploymentdashboard.usermanagement.Exceptions.UserAlreadyExistsException;
import com.stackroute.deploymentdashboard.usermanagement.Exceptions.UserNotFoundException;
import com.stackroute.deploymentdashboard.usermanagement.domains.UserModel;

public interface UserManagementService {

	void addUser(UserModel user) throws UserAlreadyExistsException;

	List<UserModel> read() throws UserNotFoundException;

	UserModel readById(String userId) throws UserNotFoundException;

	//UserModel readByUserName(String userName) throws UserNotFoundException;

	void update(UserModel updateData) throws UserNotFoundException;

	void deleteById(String userId) throws UserNotFoundException;
}
