package com.digitalhealthcare;

public class AddAvailability {
	
	public String availabilityId;           
	public String staffId;                   
	public String availabilityFlag;        
	public String weekdayName;      
	public String date;                   
	//public String endDate;                   
	public String startTime;                   
	public String endTime;                  
	public String createDatetime;       

	 public AddAvailability(String availabilityId, String staffId, String availabilityFlag, String weekdayName, String startTime, String endTime, String createDatetime, String date) {
			super();
			
			this.weekdayName=weekdayName;
			this.date=date;
			
			this.startTime=startTime;
			this.endTime=endTime;
			this.availabilityId=availabilityId;
			this.staffId=staffId;
			this.availabilityFlag=availabilityFlag;
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



	public String getCreateDatetime() {
		return createDatetime;
	}



	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}



		public String getWeekdayName() {
		return weekdayName;
	}



	public void setWeekdayName(String weekdayName) {
		this.weekdayName = weekdayName;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
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



		public AddAvailability(){
			
		}

	}

