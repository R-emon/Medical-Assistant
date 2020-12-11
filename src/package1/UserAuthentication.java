package package1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UserAuthentication {
	
	private String userName;
	private String email;
	private String password;
	private String conPassword;
	public static File signUpFile;
	public static File logInFile;
	public Scanner sc;
	
	void addUser(String userName, String email, String password, String conPassword) {
		signUpFile=new File("signUp.txt");
		logInFile=new File("login.txt");
		FileWriter fileWriter=null;
		try {
			fileWriter=new FileWriter("signUp.txt");
			
			fileWriter.write(userName+","+email+","+password+","+conPassword+"\n");
			fileWriter.write(userName+","+password+"\n");
			
			fileWriter.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public boolean verifyUser(String userName, String password) {
		boolean found=false;
		String tempUserName="";
		String tempPassword="";
		try {
			sc=new Scanner(new File("login.txt"));
			sc.useDelimiter("[,\n]");
			while(sc.hasNext() && !found) {
				tempUserName=sc.next();
				tempPassword=sc.next();
				
				if(userName.trim().equals(tempUserName.trim()) && password.trim().equals(tempPassword.trim())) {
					found=true;
					return true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConPassword() {
		return conPassword;
	}
	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}
	

}
