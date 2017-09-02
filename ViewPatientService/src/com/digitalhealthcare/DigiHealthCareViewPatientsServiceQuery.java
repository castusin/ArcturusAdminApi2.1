package com.digitalhealthcare;

public class DigiHealthCareViewPatientsServiceQuery {
	
	public static String SQL_VIEWPATIENTS = " select App_id,User_id,Account_type,First_name,Last_name,Phone_no,Email_id,Gender,Photo,DOB,Date from Profile_table where User_id=? and Account_type= ? "; 
	
}
