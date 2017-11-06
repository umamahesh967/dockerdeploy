package com.stackroute.deploymentdashboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name="userroles")
public class UserRole {

    @Id
    @GeneratedValue
    private Long roleid;
    
    @NotNull
    private String rolename;

    UserRole() {};
    
    public UserRole(String rolename) {
        this.rolename = rolename;
    }

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
