package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareDeleteStaffVacationWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareDeleteStaffVacationWebservice.class);
	DigiHealthCareDeleteStaffVacationBL deleteStaffVacationBL=new DigiHealthCareDeleteStaffVacationBL();
	
		public CISResults deleteStaffVacation(String vacationId){
			
		 CISResults cisResult = deleteStaffVacationBL.deleteStaffVacation(vacationId);
		 logger.info(" DigitalHealthCare: delete staff vacation WebService :"+cisResult);
		return cisResult;
	}
}