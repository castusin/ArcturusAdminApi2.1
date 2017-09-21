package com.digitalhealthcare;

public class DigitalHealthcareSessionsQuery {
	
	public static String SQL_CREATE_SESSION ="insert into Session_data (Session_id)"+"values(?)"; 
	 public static String SQL_CREATE_DEVICE ="insert into User_Devices (Device_Token ,Status,Device_Type,Device_id)"+"values(?,?,?,?)"; 	 

}
