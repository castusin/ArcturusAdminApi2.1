package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCaresaveStaffVacationWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCaresaveStaffVacationWebservice.class);
	
	DigiHealthCaresaveStaffVacationBL saveStaffVacationBL=new DigiHealthCaresaveStaffVacationBL();
		public CISResults saveStaffVacation(DigiHealthCaresaveStaffVacationModel saveStaffVacation) throws Throwable{
		
			CISResults cisResult=new CISResults();
			cisResult = saveStaffVacationBL.saveStaffVacation(saveStaffVacation);
			logger.info(" DigitalHealthCare:save staff vacation WebService :"+cisResult);
			return cisResult;
	}
}