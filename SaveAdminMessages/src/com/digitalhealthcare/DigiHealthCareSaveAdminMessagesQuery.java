package com.digitalhealthcare;

public class DigiHealthCareSaveAdminMessagesQuery {
	
	public static String SQL_SAVEADMINMESSAGES = "insert into Messages_table(Message_id,Apt_id,Patient_id,User_id,phoneNumber,emailId,Message_text,Create_date,Message_type)"+"values(?,?,?,?,?,?,?,?,?)"; 


}
