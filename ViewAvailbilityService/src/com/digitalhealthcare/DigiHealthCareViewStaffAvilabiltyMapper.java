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
	   viewStaff.setAvailabilityFlag(rs.getString("AvailabilityFlag"));
	   viewStaff.setWeekdayName(rs.getString("WeekdayName"));
	   viewStaff.setStartDate(rs.getString("Startdate"));
	   viewStaff.setEndDate(rs.getString("Enddate"));
	   viewStaff.setStartTime(rs.getString("Starttime"));
	   viewStaff.setEndDate(rs.getString("Endtime"));
	   viewStaff.setCreateDatetime(rs.getString("Createdatetime"));
	   
	   
	   return viewStaff;
	}
}
