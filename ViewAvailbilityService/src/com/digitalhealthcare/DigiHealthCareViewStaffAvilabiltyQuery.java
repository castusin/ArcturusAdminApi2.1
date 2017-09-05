package com.digitalhealthcare;

public class DigiHealthCareViewStaffAvilabiltyQuery {
	
	//public static final String SQL_VIEWSTAFFAVAILABILITY ="SELECT * FROM Staff_available_table where Staff_id=? ";

	public static final String SQL_VIEWSTAFFAVAILABILITY ="SELECT A.Availability_id,A.Staff_id,A.Weekday_name,A.Start_time,A.End_time from Staff_available_table A join Staff_table B on A.Staff_id=B.Staff_id where B.Staff_id=? ";

}
