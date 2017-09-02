package com.digitalhealthcare;

public class AddAvailability {
	
	public String availabilityId;           
	public String staffId;                   
	public String weekdayName;      
	public String startTime;                   
	public String endTime;                  
	public String createDatetime;       

	 public AddAvailability(String availabilityId, String staffId, String availabilityFlag, String weekdayName, String startTime, String endTime, String createDatetime, String date) {
			super();
			
			this.weekdayName=weekdayName;
			
			this.startTime=startTime;
			this.endTime=endTime;
			this.availabilityId=availabilityId;
			this.staffId=staffId;
			
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

