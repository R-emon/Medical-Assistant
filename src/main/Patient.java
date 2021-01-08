package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


public class Patient extends User implements Serializable{
	private static final long serialVersionUID = 2L;
	private ArrayList<String> addMedicineName=new ArrayList<String>();
	private ArrayList<String> addMg=new ArrayList<String>();
	private ArrayList<Boolean> addMedDelete=new ArrayList<Boolean>();
	private ArrayList<String> addPresMedicineName=new ArrayList<String>();
	private ArrayList<String> addPresMg=new ArrayList<String>();
	private ArrayList<String> addPresMorning=new ArrayList<String>();
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
	
	
	public void addUser(String filePath, ArrayList<Patient> patientsArr) {
		
		File file=new File(filePath);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			Iterator<Patient> iter= patientsArr.iterator();
			
			while(iter.hasNext()) {
				Patient tempS=(Patient) iter.next();
				oos.writeObject(tempS);
			}
			
			oos.close();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadPatientData(String filePath,ArrayList<Patient> arr) {
		File file=new File(filePath);
		try {
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			
			while(fis.available()!=0) {
				Patient tempPatient=(Patient) ois.readObject();
				arr.add(tempPatient);
			}
			
			ois.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getAddMedicineName() {
		return addMedicineName;
	}


	public void setAddMedicineName(String name) {
		this.addMedicineName.add(name.trim());
	}
	
	public void deleAddMedicineName(String name) {
		for(int i=0; i<this.addMedicineName.size(); i++) {
			if(this.addMedicineName.get(i).equalsIgnoreCase(name)) {
				this.addMedicineName.remove(i);
				break;
			}
		}
	}


	public ArrayList<String> getAddMg() {
		return addMg;
	}

	public void setAddMg(String mg) {
		this.addMg.add(mg);
	}
	
	public void deleteAddMg(String mg) {
		for(int i=0; i<this.addMg.size(); i++) {
			if(this.addMg.get(i).equalsIgnoreCase(mg)) {
				this.addMg.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAddPresMedicineName() {
		return addPresMedicineName;
	}

	public void setAddPresMedicineName(String name) {
		this.addPresMedicineName.add(name.trim());
	}
	
	public void deleteAddPressMedicineName(String name) {
		for(int i=0; i<this.addPresMedicineName.size(); i++) {
			if(this.addPresMedicineName.get(i).equalsIgnoreCase(name)) {
				this.addPresMedicineName.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAddPresMg() {
		return addPresMg;
	}

	public void setAddPresMg(String name) {
		this.addPresMg.add(name);
	}
	
	public void deleteAddPresMg(String mg) {
		for(int i=0; i<this.addPresMg.size(); i++) {
			if(this.addPresMg.get(i).equalsIgnoreCase(mg)) {
				this.addPresMg.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAddPresMorning() {
		return addPresMorning;
	}

	public void setAddPresMoring(String count) {
		this.addPresMorning.add(count);
	}
	
	public void deleteAddPresMorning(String count) {
		for(int i=0; i<this.addPresMorning.size(); i++) {
			if(this.addPresMorning.get(i).equalsIgnoreCase(count)) {
				this.addPresMorning.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAddPresEvening() {
		return addPresEvening;
	}

	public void setAddPresEvening(String count) {
		this.addPresEvening.add(count);
	}
	
	public void deleteAddPressEvening(String count) {
		for(int i=0; i<this.addPresEvening.size(); i++) {
			if(this.addPresEvening.get(i).equalsIgnoreCase(count)) {
				this.addPresEvening.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAddPresNight() {
		return addPresNight;
	}

	public void setAddPresNight(String count) {
		this.addPresNight.add(count);
	}
	
	public void deleteAddPresNight(String count) {
		for(int i=0; i<this.addPresNight.size(); i++) {
			if(this.addPresNight.get(i).equals(count)) {
				this.addPresNight.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getTotalCourseDays() {
		return totalCourseDays;
	}

	public void setTotalCourseDays(String days) {
		this.totalCourseDays.add(days);
	}
	
	public void deleteTotalCourseDays(String days) {
		for(int i=0; i<this.totalCourseDays.size(); i++) {
			if(this.totalCourseDays.get(i).equalsIgnoreCase(days)) {
				this.totalCourseDays.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAlertMedicineName() {
		return alertMedicineName;
	}

	public void setAlertMedicineName(String name) {
		this.alertMedicineName.add(name);
	}
	
	public void deleteAlertMedicineName(String name) {
		for(int i=0; i<this.alertMedicineName.size(); i++) {
			if(this.alertMedicineName.get(i).equalsIgnoreCase(name)) {
				this.alertMedicineName.remove(i);
				break;
			}
				
		}
	}

	public ArrayList<String> getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(String time) {
		this.alertTime.add(time);
	}
	
	public void deleteAlertTime(String time) {
		for(int i=0; i<this.alertTime.size(); i++) {
			if(this.alertTime.get(i).equalsIgnoreCase(time)) {
				this.alertTime.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(String date) {
		this.alertDate.add(date);	
	}
	
	public void deleteAlertDate(String date) {
		for(int i=0; i<this.alertDate.size(); i++) {
			if(this.alertDate.get(i).equalsIgnoreCase(date)) {
				this.alertDate.remove(i);
				break;
			}
				
		}
	}


	public ArrayList<String> getAlertStatus() {
		return alertStatus;
	}

	public void setAlertStaus(String alertStatus) {
		this.alertStatus.add(alertStatus);
	}
	
	public void deleteAlertStatus(String alertStatus) {
		for(int i=0; i<this.alertStatus.size(); i++) {
			if(this.alertStatus.get(i).equalsIgnoreCase(alertStatus)) {
				this.alertStatus.remove(i);
				break;
			}
				
		}
	}
	
}
