package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareDeletestaffAvilabiltyWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareDeletestaffAvilabiltyWebservice.class);
	DigiHealthCareDeletestaffAvilabiltyBL deletestaffAvilabiltyBL=new DigiHealthCareDeletestaffAvilabiltyBL();
	
		public CISResults deletestaffAvilabilty(String availabilityId){
			
		 CISResults cisResult = deletestaffAvilabiltyBL.deletestaffAvilabilty(availabilityId);
		 logger.info(" DigitalHealthCare: delete staff availability WebService :"+cisResult);
		return cisResult;
	}
}