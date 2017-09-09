package com.digitalhealthcare;

public class SmartAppointmentModel {
	
	public String serviceType;           
	                  
	public String patientId;        
	    
	                   
	public String aptWith;                   
	public int staffId;                   
	//public List<StartTime> startDateTime;  
	public String startDateTime;
	public String endDateTime;
    public SmartAppointmentModel(String serviceType, String startDate, String patientId, String startDateTime, String endDateTime, String aptWith, int staffId) {
		super();
		this.serviceType=serviceType;
		this.patientId=patientId;
		this.startDateTime=startDateTime;
		this.aptWith=aptWith;
		this.staffId=staffId;
		this.endDateTime=endDateTime;
		}


	public String getServiceType() {
		return serviceType;
	}


	public String getEndDateTime() {
		return endDateTime;
	}


	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getPatientId() {
		return patientId;
	}


	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getAptWith() {
		return aptWith;
	}

	public String getStartDateTime() {
		return startDateTime;
	}


	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}


	public void setAptWith(String aptWith) {
		this.aptWith = aptWith;
	}






	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public SmartAppointmentModel(){
		
	}

}
