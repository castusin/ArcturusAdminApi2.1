package com.digitalhealthcare;

public class SmartAppointmentModel {
	
	public String serviceType;           
	                  
	public String patientId;        
	    
	                   
	public String aptWith;                   
	public String staffId;                   
	//public List<StartTime> startDateTime;  
	public String startDateTime;
    public SmartAppointmentModel(String serviceType, String startDate, String patientId, String startDateTime, String endDateTime, String aptWith, String staffId) {
		super();
		this.serviceType=serviceType;
		this.patientId=patientId;
		this.startDateTime=startDateTime;
		this.aptWith=aptWith;
		this.staffId=staffId;
		}


	public String getServiceType() {
		return serviceType;
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


	public String getStaffId() {
		return staffId;
	}


	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}


	public SmartAppointmentModel(){
		
	}

}
