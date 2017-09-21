package com.digitalhealthcare;

import com.cis.CISResults;
import org.apache.log4j.Logger;

public class DigitalHealthCareLoginWebservice {

	static Logger logger = Logger.getLogger(DigitalHealthCareLoginWebservice.class);
	DigitalHealthCareLoginBL loginBL=new DigitalHealthCareLoginBL();
	
	
	public CISResults login(String userName,String Password) throws Throwable {
		 CISResults cisResult = loginBL.login(userName,Password);
		 logger.info(" DigitalHealthCareLoginWebservice :"+cisResult);
		return cisResult;
	}

}



	
		 
	