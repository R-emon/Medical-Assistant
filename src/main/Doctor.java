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

public class Doctor extends User implements Serializable{

	private static final long serialVersionUID = 3L;
	private ArrayList<String> addAppointPatientName=new ArrayList<String>();
	private ArrayList<String> addAppointPatientNumber=new ArrayList<String>();
	private ArrayList<String> addAppointTime=new ArrayList<String>();
	private ArrayList<String> addAppointDate=new ArrayList<String>();
	private ArrayList<String> docAlertPatientName=new ArrayList<String>();
	private ArrayList<String> docAlertTime=new ArrayList<String>();
	private ArrayList<String> docAlertDate=new ArrayList<String>();
	private ArrayList<String> docAlertStatus=new ArrayList<String>();

	public Doctor() {
		
	}
	
	public Doctor(String name, String emailAddress, String password, String confirmPassword, String userType) {
		super(name, emailAddress, password, confirmPassword, userType);
	}

	@Override
	public void setAlert() {
		
	}
	
	public void addUser(String filePath, ArrayList<Doctor> patientsArr) {
		
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
			
			Iterator<Doctor> iter= patientsArr.iterator();
			
			while(iter.hasNext()) {
				Doctor tempS=(Doctor) iter.next();
				oos.writeObject(tempS);
			}
			
			oos.close();
			fos.close();
			System.out.println("Objects written succesfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadDoctorData(String filePath,ArrayList<Doctor> arr) {
		File file=new File(filePath);
		try {
			file.createNewFile();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			//arr.clear();
			while(fis.available()!=0) {
				Doctor tempPatient=(Doctor) ois.readObject();
				//System.out.println(tempPatient.getName());
				arr.add(tempPatient);
			}
			
			ois.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAddAppointPatientName() {
		return addAppointPatientName;
	}
	
	public void setAddAppointPatientName(String name) {
		this.addAppointPatientName.add(name.trim());
	}
	
	public void deleteAddAppointPatientName(String name) {
		for(int i=0; i<this.addAppointPatientName.size(); i++) {
			if(this.addAppointPatientName.get(i).equalsIgnoreCase(name)) {
				this.addAppointPatientName.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getAddAppointPatientNumber() {
		return addAppointPatientNumber;
	}
	
	public void setAddAppointPatientNumber(String number) {
		this.addAppointPatientNumber.add(number.trim());
	}
	
	public void deleteAddAppointPatientNumber(String number) {
		for(int i=0; i<this.addAppointPatientNumber.size(); i++) {
			if(this.addAppointPatientNumber.get(i).equalsIgnoreCase(number)) {
				this.addAppointPatientNumber.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getAddAppointTime() {
		return addAppointTime;
	}
	
	public void setAddAppointTime(String time) {
		this.addAppointTime.add(time.trim());
	}
	
	public void deleteSetAppointTime(String time) {
		for(int i=0; i<this.addAppointTime.size(); i++) {
			if(this.addAppointTime.get(i).equalsIgnoreCase(time)) {
				this.addAppointTime.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getAddAppointDate() {
		return addAppointDate;
	}
	
	public void setAddAppointDate(String date) {
		this.addAppointDate.add(date.trim());
	}
	
	public void deleteSetAddAppointDate(String date) {
		for(int i=0; i<this.addAppointDate.size(); i++) {
			if(this.addAppointDate.get(i).equalsIgnoreCase(date)) {
				this.addAppointDate.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getDocAlertPatientName() {
		return docAlertPatientName;
	}
	
	public void setDocAlertPatientName(String name) {
		this.docAlertPatientName.add(name.trim());
	}
	
	public void deleteDocAlertPatientName(String name) {
		for(int i=0; i<this.docAlertPatientName.size(); i++) {
			if(this.docAlertPatientName.get(i).equalsIgnoreCase(name)) {
				this.docAlertPatientName.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getDocAlertTime() {
		return docAlertTime;
	}
	
	public void setDocAlertTime(String time) {
		this.docAlertTime.add(time.trim());
	}
	
	public void deleteDocAlertTime(String time) {
		for(int i=0; i<this.docAlertTime.size(); i++) {
			if(this.docAlertTime.get(i).equalsIgnoreCase(time)) {
				this.docAlertTime.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getDocAlertDate() {
		return docAlertDate;
	}
	
	public void setDocAlertDate(String date) {
		this.docAlertDate.add(date.trim());
	}
	
	public void deleteDocAlertDate(String date) {
		for(int i=0; i<this.docAlertDate.size(); i++) {
			if(this.docAlertDate.get(i).equalsIgnoreCase(date)) {
				this.docAlertDate.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getDocAlertStatus() {
		return docAlertStatus;
	}
	
	public void setDocAlertStatus(String status) {
		this.docAlertStatus.add(status.trim());
	}
	
	
	
}
