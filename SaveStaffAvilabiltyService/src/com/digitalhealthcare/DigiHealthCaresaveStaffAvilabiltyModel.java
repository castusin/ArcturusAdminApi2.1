
package com.digitalhealthcare;

import java.util.List;



public class DigiHealthCaresaveStaffAvilabiltyModel {
	
	
	public List<AddAvailability> staffList;
	
    public DigiHealthCaresaveStaffAvilabiltyModel(List<AddAvailability> staffList) {
		super();
		this.staffList=staffList;
		}


	
	public List<AddAvailability> getStaffList() {
		return staffList;
	}



	public void setStaffList(List<AddAvailability> staffList) {
		this.staffList = staffList;
	}



	public DigiHealthCaresaveStaffAvilabiltyModel(){
		
	}

}
