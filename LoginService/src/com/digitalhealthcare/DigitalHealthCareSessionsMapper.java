package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DigitalHealthCareSessionsMapper implements RowMapper {
	
	
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		DigitalHealthCareSessions digiSession = new DigitalHealthCareSessions();	
		digiSession.setUserName(rs.getString("userName"));
		
		digiSession.setAdminId(rs.getString("Admin_id"));
		return digiSession;
	}

}



