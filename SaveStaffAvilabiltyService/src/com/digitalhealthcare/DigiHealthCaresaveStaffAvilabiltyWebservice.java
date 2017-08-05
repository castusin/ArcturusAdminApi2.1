package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCaresaveStaffAvilabiltyWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCaresaveStaffAvilabiltyWebservice.class);
	
	DigiHealthCaresaveStaffAvilabiltyBL saveStaffAvilabiltyBL=new DigiHealthCaresaveStaffAvilabiltyBL();
		public CISResults saveStaffAvailability(DigiHealthCaresaveStaffAvilabiltyModel saveStaff) throws Throwable{
		
			CISResults cisResult=new CISResults();
			cisResult = saveStaffAvilabiltyBL.saveStaffAvailability(saveStaff);
			logger.info(" DigitalHealthCare:save staff availablity WebService :"+cisResult);
			return cisResult;
	}
}