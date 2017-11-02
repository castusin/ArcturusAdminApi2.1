
package com.digitalhealthcare;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class PatientAppointmentMapper implements RowMapper{
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PatientModel patientApt = new PatientModel();
		
		patientApt.setAptStarttime(rs.getString("Apt_starttime"));
		
		return patientApt;
	}

}
