
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class StaffVacationMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StaffModel getStafflist = new StaffModel();
		getStafflist.setStartTime(rs.getString("Start_datetime"));
		getStafflist.setStaffId(rs.getInt("Staff_id"));
		
		return getStafflist;
	}

}
