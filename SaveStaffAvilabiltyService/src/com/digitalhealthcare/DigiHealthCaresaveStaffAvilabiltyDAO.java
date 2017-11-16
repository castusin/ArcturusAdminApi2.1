
package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCaresaveStaffAvilabiltyDAO extends JdbcDaoSupport {

	public CISResults saveStaffAvailability(String availabilityId,
			String staffId,  String weekdayName,
			String startTime, String endTime,
			String createDate) {
		CISResults cisResults=new CISResults();
		AddAvailability availId=new AddAvailability();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCaresaveStaffAvilabiltyDAO.class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCaresaveStaffAvilabiltyQuery.SQL_SAVESTAFFAVAILABILITY,availabilityId,staffId,weekdayName,startTime,endTime,createDate);
			/* availId.setAvailabilityId(availabilityId);
			 cisResults.setResultObject(availId);*/
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("save staff availability  query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	
	
}
