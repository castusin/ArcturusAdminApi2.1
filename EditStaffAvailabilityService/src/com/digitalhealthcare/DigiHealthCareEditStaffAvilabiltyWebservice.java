package com.digitalhealthcare;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.cis.CISConstants;
import com.cis.CISResults;


public class DigiHealthCareEditStaffAvilabiltyWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareEditStaffAvilabiltyWebservice.class);
	
	DigiHealthCareEditStaffAvilabiltyBL editStaffAvilabiltyBL=new DigiHealthCareEditStaffAvilabiltyBL();
		public CISResults editStaffAvilabilty(DigiHealthCaresaveStaffAvilabiltyModel editStaff) throws Throwable{
		
			CISResults cisResult=new CISResults();
			cisResult = editStaffAvilabiltyBL.editStaffAvilabilty(editStaff);
			logger.info(" DigitalHealthCare:edit staff availablity WebService :"+cisResult);
			return cisResult;
	}
}