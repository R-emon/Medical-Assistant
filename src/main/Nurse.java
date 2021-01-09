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

public class Nurse extends User implements Serializable{

	private static final long serialVersionUID = 4L;
	private ArrayList<String> addVisitPatientName=new ArrayList<String>();
	private ArrayList<String> addVisitBedNumber=new ArrayList<String>();
	private ArrayList<String> addVisitMedName=new ArrayList<String>();
	private ArrayList<String> addVisitMedQty=new ArrayList<String>();
	private ArrayList<String> setAlertPatientName=new ArrayList<String>();
	private ArrayList<String> setAlertPatientBedNumber=new ArrayList<String>();
	private ArrayList<String> setAlertTime=new ArrayList<String>();
	private ArrayList<String> setAlertDate=new ArrayList<String>();
	private ArrayList<String> setAlertStatus=new ArrayList<String>();
	
	
	public Nurse() {
		
	}
	
	public Nurse(String name, String emailAddress, String password, String confirmPassword, String userType) {
		super(name, emailAddress, password, confirmPassword, userType);
	}

	
	public void addUser(String filePath, ArrayList<Nurse> nurseArr) {
		
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
			
			Iterator<Nurse> iter= nurseArr.iterator();
			
			while(iter.hasNext()) {
				Nurse tempS=(Nurse) iter.next();
				oos.writeObject(tempS);
			}
			
			oos.close();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadNurseData(String filePath,ArrayList<Nurse> arr) {
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
				Nurse tempPatient=(Nurse) ois.readObject();
				arr.add(tempPatient);
			}
			
			ois.close();
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getAddVisitPatientName() {
		return addVisitPatientName;
	}
	
	public void setAddVisitPatientName(String name) {
		this.addVisitPatientName.add(name.trim());
	}
	
	public void deleteAddVisitPatientName(String name) {
		for(int i=0; i<this.addVisitPatientName.size(); i++) {
			if(this.addVisitPatientName.get(i).equalsIgnoreCase(name)) {
				this.addVisitPatientName.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getAddVisitBedNumber() {
		return addVisitBedNumber;
	}
	
	public void setAddVisitBedNumber(String number) {
		this.addVisitBedNumber.add(number.trim());
	}
	
	public void deleteAddVisitBedNumber(String number) {
		for(int i=0; i<this.addVisitBedNumber.size(); i++) {
			if(this.addVisitBedNumber.get(i).equalsIgnoreCase(number)) {
				this.addVisitBedNumber.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getAddVisitMedName() {
		return addVisitMedName;
	}
	
	public void setAddVisitMedName(String name){
		this.addVisitMedName.add(name.trim());
	}
	
	public void deleteAddVisitMedName(String name) {
		for(int i=0; i<this.addVisitMedName.size(); i++) {
			if(this.addVisitMedName.get(i).equalsIgnoreCase(name)) {
				this.addVisitMedName.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getAddVisitMedQty() {
		return addVisitMedQty;
	}
	
	public void setAddVisitMedQty(String qty) {
		this.addVisitMedQty.add(qty.trim());
	}
	
	public void deleteAddVisitMedQty(String qty) {
		for(int i=0; i<this.addVisitMedQty.size(); i++) {
			if(this.addVisitMedQty.get(i).equalsIgnoreCase(qty)) {
				this.addVisitMedQty.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getSetAlertPatientName() {
		return setAlertPatientName;
	}
	
	public void setNurseAlertPatientName(String name) {
		this.setAlertPatientName.add(name.trim());
	}
	
	public void deleteNurseAlertPatientName(String name) {
		for(int i=0; i<this.setAlertPatientName.size(); i++) {
			if(this.setAlertPatientName.get(i).equalsIgnoreCase(name)) {
				this.setAlertPatientName.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getSetAlertPatientBedNumber() {
		return setAlertPatientBedNumber;
	}
	
	public void setAlertPatientBedNumber(String num) {
		this.setAlertPatientBedNumber.add(num.trim());
	}
	
	public void deleteNurseAlertPatientBedNumber(String num) {
		for(int i=0; i<this.setAlertPatientBedNumber.size(); i++) {
			if(this.setAlertPatientBedNumber.get(i).equalsIgnoreCase(num)) {
				this.setAlertPatientBedNumber.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getSetAlertTime() {
		return setAlertTime;
	}
	
	public void setNurseAlertTime(String time) {
		this.setAlertTime.add(time.trim());
	}
	
	public void deleteNurseAlertTime(String time) {
		for(int i=0; i<this.setAlertTime.size(); i++) {
			if(this.setAlertTime.get(i).equalsIgnoreCase(time)) {
				this.setAlertTime.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getSetAlertDate() {
		return setAlertDate;
	}
	
	public void setNurseAlertDate(String date) {
		this.setAlertDate.add(date.trim());
	}
	
	public void deleteNurseAlertDate(String Date) {
		for(int i=0; i<this.setAlertDate.size(); i++) {
			if(this.setAlertDate.get(i).equalsIgnoreCase(Date)) {
				this.setAlertDate.remove(i);
				break;
			}
		}
	}

	public ArrayList<String> getSetAlertStatus() {
		return setAlertStatus;
	}
	
	public void setNurseAlertStatus(String status) {
		this.setAlertStatus.add(status.trim());
	}
	
}
