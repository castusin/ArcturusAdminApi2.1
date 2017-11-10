package com.digitalhealthcare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Darshan
 *
 */
@SuppressWarnings("rawtypes")
public class StaffAppointmentMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StaffModel getAppointmentStaffList = new StaffModel();
		getAppointmentStaffList.setStaffId(rs.getInt("Apt_person_id"));
		getAppointmentStaffList.setStartTime(rs.getString("Apt_starttime"));
		return getAppointmentStaffList;
	}
}