package com.digitalhealthcare;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class DigiHealthCareDeletestaffAvilabiltyDAO extends JdbcDaoSupport {

	public CISResults deletestaffAvilabilty(String availabilityId) {
		
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareDeletestaffAvilabiltyDAO.class);
		Object[] inputs = new Object[]{availabilityId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getJdbcTemplate().update(DigiHealthCareDeletestaffAvilabiltyQuery.SQL_DELETESTAFFAVAILABILITY,inputs);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("delete staff availability query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get Profile Data");
		}
   		return cisResults; 
	}
}
