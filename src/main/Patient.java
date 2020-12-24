package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Patient extends User implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<String> addMedicineName=new ArrayList<String>();
	private ArrayList<String> addMg=new ArrayList<String>();
	private ArrayList<Boolean> addMedDelete=new ArrayList<Boolean>();
	private ArrayList<String> addPresMedicineName=new ArrayList<String>();
	private ArrayList<String> addPresMg=new ArrayList<String>();
	private ArrayList<String> addPresMornig=new ArrayList<String>();
	private ArrayList<String> addPresEvening=new ArrayList<String>();
	private ArrayList<String> addPresNight=new ArrayList<String>();
	private ArrayList<String> totalCourseDays=new ArrayList<String>();
	private ArrayList<Boolean> addPresDelete=new ArrayList<Boolean>();
	private ArrayList<String> alertMedicineName=new ArrayList<String>();
	private ArrayList<String> alertTime=new ArrayList<String>();
	private ArrayList<String> alertDate=new ArrayList<String>();
	private ArrayList<String> alertStatus=new ArrayList<String>();
	
	
	public Patient() {
		
	}
	public Patient(String name, String emailAddress, String password, String confirmPassword, String userType) {
		super(name, emailAddress, password, confirmPassword, userType);
	}
	
	
	@Override
	public void setAlert() {
		
	}



	public ArrayList<String> getAddMedicineName() {
		return addMedicineName;
	}


	public void setAddMedicineName(String name) {
		this.addMedicineName.add(name);
	}
	
	public void deleAddMedicineName(String name) {
		for(int i=0; i<this.addMedicineName.size(); i++) {
			if(this.addMedicineName.get(i).equals(name))
				this.addMedicineName.remove(i);
		}
	}
//	public void setAddMedicineName(ArrayList<String> addMedicineName) {
//		this.addMedicineName = addMedicineName;
//	}



	public ArrayList<String> getAddMg() {
		return addMg;
	}

	public void setAddMg(String mg) {
		this.addMg.add(mg);
	}
	
	public void deleteAddMg(String mg) {
		for(int i=0; i<this.addMg.size(); i++) {
			if(this.addMg.get(i).equals(mg))
				this.addMg.remove(i);
		}
	}

//	public void setAddMg(ArrayList<String> addMg) {
//		this.addMg = addMg;
//	}



	public ArrayList<Boolean> getAddMedDelete() {
		return addMedDelete;
	}



	public void setAddMedDelete(ArrayList<Boolean> addMedDelete) {
		this.addMedDelete = addMedDelete;
	}



	public ArrayList<String> getAddPresMedicineName() {
		return addPresMedicineName;
	}



	public void setAddPresMedicineName(ArrayList<String> addPresMedicineName) {
		this.addPresMedicineName = addPresMedicineName;
	}



	public ArrayList<String> getAddPresMg() {
		return addPresMg;
	}



	public void setAddPresMg(ArrayList<String> addPresMg) {
		this.addPresMg = addPresMg;
	}



	public ArrayList<String> getAddPresMornig() {
		return addPresMornig;
	}



	public void setAddPresMornig(ArrayList<String> addPresMornig) {
		this.addPresMornig = addPresMornig;
	}



	public ArrayList<String> getAddPresEvening() {
		return addPresEvening;
	}



	public void setAddPresEvening(ArrayList<String> addPresEvening) {
		this.addPresEvening = addPresEvening;
	}



	public ArrayList<String> getAddPresNight() {
		return addPresNight;
	}



	public void setAddPresNight(ArrayList<String> addPresNight) {
		this.addPresNight = addPresNight;
	}



	public ArrayList<String> getTotalCourseDays() {
		return totalCourseDays;
	}



	public void setTotalCourseDays(ArrayList<String> totalCourseDays) {
		this.totalCourseDays = totalCourseDays;
	}



	public ArrayList<Boolean> getAddPresDelete() {
		return addPresDelete;
	}



	public void setAddPresDelete(ArrayList<Boolean> addPresDelete) {
		this.addPresDelete = addPresDelete;
	}



	public ArrayList<String> getAlertMedicineName() {
		return alertMedicineName;
	}



	public void setAlertMedicineName(ArrayList<String> alertMedicineName) {
		this.alertMedicineName = alertMedicineName;
	}



	public ArrayList<String> getAlertTime() {
		return alertTime;
	}



	public void setAlertTime(ArrayList<String> alertTime) {
		this.alertTime = alertTime;
	}



	public ArrayList<String> getAlertDate() {
		return alertDate;
	}



	public void setAlertDate(ArrayList<String> alertDate) {
		this.alertDate = alertDate;
	}



	public ArrayList<String> getAlertStatus() {
		return alertStatus;
	}



	public void setAlertStatus(ArrayList<String> alertStatus) {
		this.alertStatus = alertStatus;
	}
	
	

}
