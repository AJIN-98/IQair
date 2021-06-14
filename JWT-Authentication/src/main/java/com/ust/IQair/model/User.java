package com.ust.IQair.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
    
	@Id
    private String userId;
    private String firstName;
    private String lastName;
    private String userPassword;
    private String email;
    
	public User() {
		super();
	}
	
	public User(String userId, String firstName, String lastName, String userPassword, 
			String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userPassword = userPassword;
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userPassword="
		+ userPassword + "Email=" + email + "]";
	}
    

}