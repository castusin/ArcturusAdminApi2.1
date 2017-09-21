package com.digitalhealthcare;

public class DigitalHealthCareSessions {
	

		public String userName;
		public String password;
		public String adminId;
		
		
	public DigitalHealthCareSessions(String userName, String password, String adminId) {
			super();
			this.userName = userName;
			this.password = password;
			this.adminId=adminId;
			
		}


	public String getAdminId() {
		return adminId;
	}


	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public DigitalHealthCareSessions(){
			
		}
	}


