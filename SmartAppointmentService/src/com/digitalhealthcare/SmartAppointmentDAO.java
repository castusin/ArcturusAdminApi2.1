package com.digitalhealthcare;

import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class SmartAppointmentDAO extends JdbcDaoSupport {

	public CISResults smartAppointmentService(String serviceType,
			String patientId, String aptWith, String staffId, String startDateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public CISResults getPatientDetails(String patientId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		StaffModel getPatientEmail=new StaffModel();
		Object[] inputs = new Object[]{patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 PatientModel res=(PatientModel)getJdbcTemplate().queryForObject(SmartAppointmentQuery.SQL_GETPATIENTEMAIL,inputs,new PatientMapper());
		     cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("patient email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	public CISResults getStaffDetails(String staffId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		StaffModel getstaffEmail=new StaffModel();
		Object[] inputs = new Object[]{staffId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 StaffModel res=(StaffModel)getJdbcTemplate().queryForObject(SmartAppointmentQuery.SQL_GETSTAFFEMAIL,inputs,new StaffMapper());
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

}
