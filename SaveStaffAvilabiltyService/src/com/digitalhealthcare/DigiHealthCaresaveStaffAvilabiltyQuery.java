package com.digitalhealthcare;

public class DigiHealthCaresaveStaffAvilabiltyQuery {
	
	public static String SQL_SAVESTAFFAVAILABILITY = "insert into Staff_available_table(Availability_id,Staff_id,AvailabilityFlag,WeekdayName,Startdate,Enddate,Starttime,Endtime,Createdatetime)"+"values(?,?,?,?,?,?,?,?,?)"; 


}
