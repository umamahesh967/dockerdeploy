package com.stackroute.deploymentdashboard.usermanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.deploymentdashboard.usermanagement.Exceptions.UserAlreadyExistsException;
import com.stackroute.deploymentdashboard.usermanagement.Exceptions.UserNotFoundException;
import com.stackroute.deploymentdashboard.usermanagement.domains.UserModel;
import com.stackroute.deploymentdashboard.usermanagement.repository.UserManagementCRUDRepository;

/*
 * Service for CRUD operations on USERS
 * 
 * */

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserManagementCRUDRepository userRepo;

	/*
	 * Adding a user
	 */
	@Override
	public void addUser(UserModel user) throws UserAlreadyExistsException {
		if (this.userRepo.exists(user.getUserId())) {
			throw new UserAlreadyExistsException("User with Id " + user.getUserId() + " already exist");
		} else {
			this.userRepo.save(user);
		}

	}

	/*
	 * Reading List of users
	 */
	@Override
	public List<UserModel> read() throws UserNotFoundException {
		if (this.userRepo.findAll() == null) {
			throw new UserNotFoundException("No Users Found");
		} else {
			return (List<UserModel>) this.userRepo.findAll();
		}
	}

	/*
	 * Reading a user by userId
	 */
	@Override
	public UserModel readById(String userId) throws UserNotFoundException {
		if (this.userRepo.exists(userId)) {
			return this.userRepo.findOne(userId);
		} else {
			throw new UserNotFoundException("User with Id " + userId + " does not exist");
		}
	}

	/*
	 * Reading a user by userName
	 */
	/*
	  @Override public UserModel readByUserName(String userName) throws
	  UserNotFoundException { if (this.userRepo.findByUserName(userName) == null) {
	  throw new UserNotFoundException("User with userName " + userName +
	  " does not exist"); } else { return this.userRepo.findByUserName(userName); }
	 
	  }
	 */

	/*
	 * Updating a user
	 */
	@Override
	public void update(UserModel updateData) throws UserNotFoundException {
		if (this.userRepo.exists(updateData.getUserId())) {
			this.userRepo.save(updateData);
		} else {
			throw new UserNotFoundException("User with Id " + updateData.getUserId() + " does not exist");
		}

	}

	/*
	 * Deleting a user
	 */
	@Override
	public void deleteById(String userId) throws UserNotFoundException {
		if (this.userRepo.exists(userId)) {
			this.userRepo.delete(userId);
		} else {
			throw new UserNotFoundException("User with Id " + userId + " does not exist");
		}

	}

}
