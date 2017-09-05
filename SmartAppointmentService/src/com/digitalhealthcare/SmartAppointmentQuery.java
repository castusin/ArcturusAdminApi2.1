package com.digitalhealthcare;

public class SmartAppointmentQuery {
	
	public static String SQL_GETSTAFFEMAIL = " select Lattitude,Longitude from Staff_table where Staff_id= ? "; 

	public static String SQL_GETPATIENTEMAIL = " select Lattitude,Longitude from Profile_table where User_id= ? "; 

}
