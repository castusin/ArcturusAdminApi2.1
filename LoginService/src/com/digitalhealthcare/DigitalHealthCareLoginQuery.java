package com.digitalhealthcare;

public class DigitalHealthCareLoginQuery {
	
	public static String SQL_LOGIN = "select Admin_id, username, Create_date, Status from Admin_table where userName=? and password=?"; 
    
	public static String SQL_GETPASSWORD = "select password from Admin_table where userName=?"; 
	

}

