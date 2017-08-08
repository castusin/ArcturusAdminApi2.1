package com.digitalhealthcare;


import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCareSaveAdminMessagesWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareSaveAdminMessagesWebservice.class);
	
	DigiHealthCareSaveAdminMessagesBL saveAdminMessagesBL=new DigiHealthCareSaveAdminMessagesBL();
		public CISResults saveAdminMessages(DigiHealthCareSaveAdminMessagesModel saveMessages) throws Throwable{
		
			CISResults cisResult=new CISResults();
			cisResult = saveAdminMessagesBL.saveAdminMessages(saveMessages);
			logger.info(" DigitalHealthCare:save admin messages WebService :"+cisResult);
			return cisResult;
	}
}