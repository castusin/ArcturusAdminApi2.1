
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class PatientMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PatientModel getStafflist = new PatientModel();
		getStafflist.setLattitude(rs.getFloat("Lattitude"));
		getStafflist.setLongitude(rs.getFloat("Longitude"));
		
		return getStafflist;
	}

}
