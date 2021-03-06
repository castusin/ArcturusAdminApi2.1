package com.digitalhealthcare;

public class SmartAppointmentQuery {
	
	public static String SQL_GETSTAFFEMAIL = " select Lattitude,Longitude from Staff_table where Staff_id= ? "; 

	public static String SQL_GETPATIENTEMAIL = " select Lattitude,Longitude from Profile_table where User_id= ? "; 

	//public static String SQL_GETSTAFFSERVICETYPE = " SELECT S.Staff_id, S.Fname, S.Lname,S.Servicetype,SA.Weekday_name, SA.Start_time, SA.End_time FROM Staff_table S JOIN Staff_available_table SA ON S.Staff_id = SA.Staff_id WHERE S.Servicetype = ? AND SA.Start_time >=  '12:00:00 am'  AND SA.End_time <=  '1:00:00 pm'"; 

	//public static String SQL_GETSTAFFVACATION = " SELECT Staff_id,Start_datetime FROM Staff_vacation WHERE Staff_id =? AND Start_datetime =  ?"; 

	public static String SQL_GETSTAFFAPPOINTMENT = " SELECT Apt_starttime FROM Appointments_table WHERE Apt_person_id =? AND Apt_starttime =  ?"; 

	public static String SQL_GETPATIENTAPPOINTMENT = " SELECT Apt_starttime FROM Appointments_table WHERE Patient_id =? AND Apt_starttime =  ?"; 

	public static String SQL_GETSTAFFSERVICETYPE = " SELECT S.Staff_id, S.Fname, S.Lname,S.Servicetype,S.Longitude,S.Lattitude,SA.Weekday_name,SA.Start_time, SA.End_time FROM Staff_table	S, Staff_available_table SA	where S.Staff_id = SA.Staff_id 	and S.Servicetype = ? AND SA.start_time <=  ?  AND SA.End_time >=  ?	AND SA.Weekday_name = DAYNAME(  ? ) "; 

	public static String SQL_GETSTAFFVACATION = " select * from Staff_vacation where STR_TO_DATE(?,'%Y-%m-%d')>= DATE(str_to_date(Start_datetime,'%a %b %d %Y %T')) and STR_TO_DATE(?,'%Y-%m-%d')<= DATE(str_to_date(end_datetime,'%a %b %d %Y %T'))and Staff_id in (?)";
	
}