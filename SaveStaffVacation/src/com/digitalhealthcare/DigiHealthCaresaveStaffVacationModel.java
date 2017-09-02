package com.digitalhealthcare;

import java.util.List;



public class DigiHealthCaresaveStaffVacationModel {
	
	
	public String vacationId;
	public String staffId;
	public String startTime;
	public String endTime;
	public String vacationNote;
	public String createdTime;
	
    public DigiHealthCaresaveStaffVacationModel(String vacationId, String staffId, String startTime, String endTime, String vacationNote, String createdTime) {
		super();
		this.vacationId=vacationId;
		this.staffId=staffId;
		this.startTime=startTime;
		this.endTime=endTime;
		this.vacationNote=vacationNote;
		this.createdTime=createdTime;
		}


	


	public String getCreatedTime() {
		return createdTime;
	}





	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}





	public String getVacationId() {
		return vacationId;
	}





	public void setVacationId(String vacationId) {
		this.vacationId = vacationId;
	}





	public String getStaffId() {
		return staffId;
	}





	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}





	public String getStartTime() {
		return startTime;
	}





	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}





	public String getEndTime() {
		return endTime;
	}





	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}





	public String getVacationNote() {
		return vacationNote;
	}





	public void setVacationNote(String vacationNote) {
		this.vacationNote = vacationNote;
	}

	public DigiHealthCaresaveStaffVacationModel(){
		
	}

}
