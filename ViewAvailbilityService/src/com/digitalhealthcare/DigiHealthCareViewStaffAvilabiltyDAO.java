package com.digitalhealthcare;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

/**
 * @author 
 *
 */
public class DigiHealthCareViewStaffAvilabiltyDAO extends JdbcDaoSupport {

	public CISResults viewstaffAvilabilty(String staffId){

		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Logger logger = Logger.getLogger(DigiHealthCareViewStaffAvilabiltyDAO.class);
		Object[] inputs = new Object[]{staffId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 List viewStaffAvailability=getJdbcTemplate().query(DigiHealthCareViewStaffAvilabiltyQuery.SQL_VIEWSTAFFAVAILABILITY,inputs,new DigiHealthCareViewStaffAvilabiltyMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 cisResults.setResultObject(viewStaffAvailability);
			 logger.info("view messages query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}


}
