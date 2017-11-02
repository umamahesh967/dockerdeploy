package com.stackroute.deploymentdashboard.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="UserInfo")
public class UserInfo {
	@Id
	@GeneratedValue
	private Integer userid;
	
	@Column
	@NotNull
	private Integer psaid;
	
	@Column
	@NotNull
	private String username;
	
	@Column
	@NotNull
	@Size(min=8, max=60)
	private String password;
	
	@Column
	@NotNull
	@Pattern(regexp = "[a-z0-9.]+@cgi.com")
	private String email;

	@NotNull
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<UserRole> roles;
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getPsaid() {
		return psaid;
	}

	public void setPsaid(Integer psaid) {
		this.psaid = psaid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
}
