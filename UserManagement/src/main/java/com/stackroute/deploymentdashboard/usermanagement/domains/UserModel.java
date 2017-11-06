 package com.stackroute.deploymentdashboard.usermanagement.domains;

 import org.springframework.data.annotation.Id;
// import javax.persistence.Id; 

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;


@Document(collection="users")
public class UserModel {
	
	// private String id;
	
	@Id
	private String userId;
	
	@ApiModelProperty
	private String userName;
	
	@ApiModelProperty
	private String emailId;
	
	private String gender;
	
	private String userStatus;
	
	public UserModel() {}

	public UserModel(String id, String username, String emailid,String gender, String userStatus) {
		super();
		this.userId = id;
		this.userName = username;
		this.emailId = emailid;
		this.gender = gender;
		this.userStatus = userStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {
		this.userId = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailid) {
		this.emailId = emailid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	
	
}
