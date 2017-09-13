package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class StaffServiceTypeMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StaffModel getStafflist = new StaffModel();
		getStafflist.setStaffId(rs.getInt("Staff_id"));
		getStafflist.setfName(rs.getString("Fname"));
		getStafflist.setlName(rs.getString("Lname"));
		getStafflist.setStartTime(rs.getString("Start_time"));
		getStafflist.setEndTime(rs.getString("End_time"));
		getStafflist.setServiceType(rs.getString("Servicetype"));
		getStafflist.setWeekday(rs.getString("Weekday_name"));
		
		return getStafflist;
	}

}
