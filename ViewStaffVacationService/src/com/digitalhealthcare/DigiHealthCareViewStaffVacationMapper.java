package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
public class DigiHealthCareViewStaffVacationMapper implements RowMapper{
public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	DigiHealthCaresaveStaffVacationModel vacation = new DigiHealthCaresaveStaffVacationModel();
	   
	  
		vacation.setVacationId(rs.getString("Staff_vacationId"));
		vacation.setStaffId(rs.getString("Staff_id"));
		vacation.setStartTime(rs.getString("Start_datetime"));
		vacation.setEndTime(rs.getString("End_datetime"));
		vacation.setVacationNote(rs.getString("Vacation_note"));
		vacation.setCreatedTime(rs.getString("Create_datetime"));
	   
	   return vacation;
	}
}
