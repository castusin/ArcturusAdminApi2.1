package com.digitalhealthcare;

public class DigiHealthCareEditStaffAvilabiltyQuery {
	
	//public static String SQL_EDITSTAFFAVAILABILITY = "insert into Staff_available_table(Availability_id,Staff_id,Weekday_name,Start_time,End_time,Create_datetime)"+"values(?,?,?,?,?,?)"; 
	public static String SQL_EDITSTAFFAVAILABILITY="UPDATE Staff_available_table  set Weekday_name =?,Start_time =?,End_time =? where Availability_id=? " ;


}
