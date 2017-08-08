

package com.digitalhealthcare;



public class DigiHealthCareSaveAdminMessagesModel {
	
	public String messageId;           
	public String aptId;                   
	public String patientId;        
	public String userId;      
	public String phoneNumber;                   
	public String emailId;                   
	public String messageText;                   
	public String createdDate;                  
	public String messageType;    

    public DigiHealthCareSaveAdminMessagesModel(String messageId, String aptId, String patientId, String userId, String phoneNumber, String emailId, String messageText, String createdDate, String messageType) {
		super();
		this.messageId=messageId;
		this.aptId=aptId;
		this.patientId=patientId;
		this.userId=userId;
		this.phoneNumber=phoneNumber;
		this.emailId=emailId;
		this.messageText=messageText;
		this.createdDate=createdDate;
		this.messageType=messageType;
		
	
		}




	public String getMessageId() {
		return messageId;
	}




	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}




	public String getAptId() {
		return aptId;
	}




	public void setAptId(String aptId) {
		this.aptId = aptId;
	}




	public String getPatientId() {
		return patientId;
	}




	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getEmailId() {
		return emailId;
	}




	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




	public String getMessageText() {
		return messageText;
	}




	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}




	public String getCreatedDate() {
		return createdDate;
	}




	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}




	public String getMessageType() {
		return messageType;
	}




	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}




	public DigiHealthCareSaveAdminMessagesModel(){
		
	}

}
