package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class DigiHealthCareViewStaffAvilabiltyMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	   DigiHealthCaresaveStaffAvilabiltyModel viewStaff = new DigiHealthCaresaveStaffAvilabiltyModel();
	
	   viewStaff.setAvailabilityId(rs.getString("Availability_id"));
	   viewStaff.setStaffId(rs.getString("Staff_id"));
	   viewStaff.setAvailabilityFlag(rs.getString("Availability_flag"));
	   viewStaff.setWeekdayName(rs.getString("Weekday_name"));
	   viewStaff.setDate(rs.getString("Date"));
	   viewStaff.setStartTime(rs.getString("Start_time"));
	   viewStaff.setEndTime(rs.getString("End_time"));
	   viewStaff.setCreateDatetime(rs.getString("Create_datetime"));
	   
	   
	   return viewStaff;
	}
}
