package com.stackroute.deploymentdashboard.model;

import java.math.BigInteger;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("emp")
public class UserCredentials {
	@PrimaryKey
	int emp_id;
	
	String emp_city;
	String emp_name;
	BigInteger emp_phone;
	int emp_sal;
	
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_city() {
		return emp_city;
	}
	public void setEmp_city(String emp_city) {
		this.emp_city = emp_city;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public BigInteger getEmp_phone() {
		return emp_phone;
	}
	public void setEmp_phone(BigInteger emp_phone) {
		this.emp_phone = emp_phone;
	}
	public int getEmp_sal() {
		return emp_sal;
	}
	public void setEmp_sal(int emp_sal) {
		this.emp_sal = emp_sal;
	}
}