package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCareEditStaffVacationWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareEditStaffVacationWebservice.class);
	
	DigiHealthCareEditStaffVacationBL editStaffVacationBL=new DigiHealthCareEditStaffVacationBL();
		public CISResults editStaffVacation(DigiHealthCaresaveStaffVacationModel editStaffVacation) throws Throwable{
		
			CISResults cisResult=new CISResults();
			cisResult = editStaffVacationBL.editStaffVacation(editStaffVacation);
			logger.info(" DigitalHealthCare:edit staff vacation WebService :"+cisResult);
			return cisResult;
	}
}