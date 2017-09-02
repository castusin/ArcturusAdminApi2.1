
package com.digitalhealthcare;


import org.apache.log4j.Logger;

import com.cis.CISResults;


public class SmartAppointmentWebservice {
	
	static Logger logger = Logger.getLogger(SmartAppointmentWebservice.class);
	
	SmartAppointmentBL smartAppointmentBL=new SmartAppointmentBL();
		public CISResults smartAppointmentService(SmartAppointmentModel smartAppointment) throws Throwable{
		
			CISResults cisResult=new CISResults();
			cisResult = smartAppointmentBL.smartAppointmentService(smartAppointment);
			logger.info(" DigitalHealthCare:smartAppointment  WebService :"+cisResult);
			return cisResult;
	}
}