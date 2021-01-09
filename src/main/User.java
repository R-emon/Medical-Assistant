package main;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable{
	private static final long serialVersionUID = 1L;
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
	
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String email) {
		this.emailAddress = email;
	}

	public String getPassword() {
		return this.password;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	

}
