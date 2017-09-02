package com.digitalhealthcare;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;



public class DigiHealthCareViewPatientsServiceDAO extends JdbcDaoSupport {

	public CISResults viewPatientdetails(String patientId){
	CISResults cisResults=new CISResults();
	cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	Logger logger = Logger.getLogger(DigiHealthCareViewPatientsServiceDAO.class);
	//hard coded, will change later
	String accountType="P";
	Object[] inputs = new Object[]{patientId,accountType};
	try{
		// Capture service Start time
		 TimeCheck time=new TimeCheck();
		 testServiceTime sessionTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 List viewPatientDetails=getJdbcTemplate().query(DigiHealthCareViewPatientsServiceQuery.SQL_VIEWPATIENTS,inputs,new DigiHealthCareViewPatientsServiceMapper());
		 String serviceEndTime=time.getTimeZone();
		 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
		 cisResults.setResultObject(viewPatientDetails);
		 logger.info("view messages query time:: " +result);
		
	} catch (DataAccessException e) {
		e.printStackTrace();
	
		cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
		cisResults.setErrorMessage("Failed to get  Data");
	}
		return cisResults; 

	}
}