package main;

import java.util.ArrayList;

public abstract class User {
	private String name;
	private String emailAddress;
	private String password;
	private String confirmPassword;
	private String userType;
	
	public User() {
		
	}
	
	public User(String name, String emailAddress, String password, String confirmPassword, String userType) {
		this.name=name;
		this.emailAddress=emailAddress;
		this.password=password;
		this.confirmPassword=confirmPassword;
		this.userType=userType;
	}
	
	public abstract void setAlert();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	

}
