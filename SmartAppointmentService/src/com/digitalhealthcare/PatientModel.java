package com.digitalhealthcare;

import java.sql.Date;

public class PatientModel {
	

	
	float lattitude;
	float longitude;
	
	String aptStarttime;
    public PatientModel(int staffId, String fName, String lName, String emailId, String serviceType, String phone1, String phone2, String address1, String address2, String city, String country, String state, int zipcode, String activeInd, Date createDate, String county, float lattitude, float longitude, String aptStarttime ) {
		super();
	
		
		this.lattitude=lattitude;
		this.longitude=longitude;
		this.aptStarttime=aptStarttime;
	}



	



	public String getAptStarttime() {
		return aptStarttime;
	}







	public void setAptStarttime(String aptStarttime) {
		this.aptStarttime = aptStarttime;
	}







	public float getLattitude() {
		return lattitude;
	}







	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}







	public float getLongitude() {
		return longitude;
	}







	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}







	public PatientModel(){
		
	}

}