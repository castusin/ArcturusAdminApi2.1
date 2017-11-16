/**
 * 
 */
package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Darshan
 *
 */
@SuppressWarnings("rawtypes")
public class StaffDistancesMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StaffModel getAppointmentStaffList = new StaffModel();
		getAppointmentStaffList.setStaffId(rs.getInt("staff_id"));
		getAppointmentStaffList.setLattitude(rs.getFloat("latitude"));
		getAppointmentStaffList.setLongitude(rs.getFloat("longitude"));
		return getAppointmentStaffList;
	}

}
