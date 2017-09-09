package com.digitalhealthcare;

public class SmartAppointmentQuery {
	
	public static String SQL_GETSTAFFEMAIL = " select Lattitude,Longitude from Staff_table where Staff_id= ? "; 

	public static String SQL_GETPATIENTEMAIL = " select Lattitude,Longitude from Profile_table where User_id= ? "; 

	public static String SQL_GETSTAFFSERVICETYPE = " SELECT S.Staff_id, S.Fname, S.Lname,S.Servicetype, SA.Start_time, SA.End_time FROM Staff_table S JOIN Staff_available_table SA ON S.Staff_id = SA.Staff_id WHERE S.Servicetype = ? AND HOUR( SA.Start_time ) BETWEEN  '9:00:00' AND  '10:00:00' "; 

	public static String SQL_GETSTAFFVACATION = " SELECT Staff_id,Start_datetime FROM Staff_vacation WHERE Staff_id =? AND Start_datetime =  ?"; 

	public static String SQL_GETSTAFFAPPOINTMENT = " SELECT Apt_starttime FROM Appointments_table WHERE Apt_person_id =? AND Apt_starttime =  ?"; 

}
