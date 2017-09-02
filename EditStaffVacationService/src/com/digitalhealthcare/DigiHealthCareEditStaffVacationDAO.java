package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareEditStaffVacationDAO extends JdbcDaoSupport {

	public CISResults editStaffVacation(String vacationId, String staffId,
			String startTime, String endTime, String vacationNote,
			String createDate) {


		CISResults cisResults=new CISResults();
		DigiHealthCaresaveStaffVacationModel vacation =new DigiHealthCaresaveStaffVacationModel();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCaresaveStaffVacationDAO .class);
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareEditStaffVacationQuery.SQL_EDITSTAFFAVACATION,startTime,endTime,vacationNote,vacationId);
			 vacation.setVacationId(vacationId);
			 vacation.setStartTime(startTime);
			 vacation.setEndTime(endTime);
			 vacation.setVacationNote(vacationNote);
			 vacation.setStaffId(staffId);
			 cisResults.setResultObject(vacation);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("edit staff vacation  query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	
	
}

