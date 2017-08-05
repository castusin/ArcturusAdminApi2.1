
package com.digitalhealthcare;



public class DigiHealthCaresaveStaffAvilabiltyModel {
	
	public String availabilityId;           
	public String staffId;                   
	public String availabilityFlag;        
	public String weekdayName;      
	public String startDate;                   
	public String endDate;                   
	public String startTime;                   
	public String endTime;                  
	public String createDatetime;    

    public DigiHealthCaresaveStaffAvilabiltyModel(String availabilityId, String staffId, String availabilityFlag, String weekdayName, String startDate, String endDate, String startTime, String endTime, String createDatetime) {
		super();
		this.availabilityId=availabilityId;
		this.staffId=staffId;
		this.availabilityFlag=availabilityFlag;
		this.weekdayName=weekdayName;
		this.startDate=startDate;
		this.endDate=endDate;
		this.startTime=startTime;
		this.endTime=endTime;
		this.createDatetime=createDatetime;
		}


	public String getAvailabilityId() {
		return availabilityId;
	}


	public void setAvailabilityId(String availabilityId) {
		this.availabilityId = availabilityId;
	}


	public String getStaffId() {
		return staffId;
	}


	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}


	public String getAvailabilityFlag() {
		return availabilityFlag;
	}


	public void setAvailabilityFlag(String availabilityFlag) {
		this.availabilityFlag = availabilityFlag;
	}


	public String getWeekdayName() {
		return weekdayName;
	}


	public void setWeekdayName(String weekdayName) {
		this.weekdayName = weekdayName;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
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


	public String getCreateDatetime() {
		return createDatetime;
	}


	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}


	public DigiHealthCaresaveStaffAvilabiltyModel(){
		
	}

}
