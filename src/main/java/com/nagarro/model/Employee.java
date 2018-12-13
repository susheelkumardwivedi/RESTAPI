package com.nagarro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	 int code;
	@Column(name = "NAME")
	 String name;
	@Column(name = "LOCATION")
	 String location;
	@Column(name = "EMAIL")
	 String email;
	@Column(name = "DOB")
	 String dob;
	@Column(name = "MANAGER")
	private String manager;

	public int getCode() {
		return code;
	}

	public String getDob() {
		return dob;
	}

	public String getEmail() {
		return email;
	}

	public String getLocation() {
		return location;
	}

	public String getManager() {
		return manager;
	}

	public String getName() {
		return name;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void setName(String name) {
		this.name = name;
	}

}
