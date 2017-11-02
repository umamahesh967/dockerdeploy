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
	
	public UserModel() {}

	public UserModel(String id, String username, String emailid) {
		super();
		this.userId = id;
		this.userName = username;
		this.emailId = emailid;
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

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	
	
}
