package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class StaffMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StaffModel getStafflist = new StaffModel();
		getStafflist.setLattitude(rs.getFloat("Lattitude"));
		getStafflist.setLongitude(rs.getFloat("Longitude"));
		
		return getStafflist;
	}

}
