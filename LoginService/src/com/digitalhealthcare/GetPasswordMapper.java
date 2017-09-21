package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public abstract class GetPasswordMapper implements RowMapper {
	
	
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			DigitalHealthCareSessions login = new DigitalHealthCareSessions();	
			
			login.setPassword(rs.getString("password"));
			
			return login;
		}


}









		

