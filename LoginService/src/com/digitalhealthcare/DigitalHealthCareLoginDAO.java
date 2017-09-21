package com.digitalhealthcare;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;

public class DigitalHealthCareLoginDAO extends JdbcDaoSupport {

	
	public CISResults login(String userName,String password) {
		
		//Logger logger = Logger.getLogger(LoginDAO.class);
		
		CISResults cisResults=new CISResults();
		DigitalHealthCareSessions loginModel;
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{userName,password};
		try{	
			// Capture service Start time
			
			 loginModel=(DigitalHealthCareSessions)getJdbcTemplate().queryForObject(DigitalHealthCareLoginQuery.SQL_LOGIN,inputs,new DigitalHealthCareSessionsMapper());
			
			 loginModel.setAdminId(loginModel.getAdminId());
			 loginModel.setUserName(loginModel.getUserName());
			 cisResults.setResultObject(loginModel);
			
		
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage(CISConstants. USER_LOGIN_STATUS);
		}

   		return cisResults;  
	}

	
}




		
	
