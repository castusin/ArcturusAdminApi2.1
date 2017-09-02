package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class DigiHealthCareViewPatientsServiceWebservice {
	
	static Logger logger = Logger.getLogger(DigiHealthCareViewPatientsServiceWebservice.class);
	
	DigiHealthCareViewPatientsServiceBL viewPatientsServiceBL=new DigiHealthCareViewPatientsServiceBL();

		public CISResults viewPatients(String patientId) {
			CISResults  cisResult = viewPatientsServiceBL.viewPatients(patientId);
		 logger.info(" DigitalHealthCare:viewPatientsWebService :"+cisResult);
		return cisResult;
	}
}