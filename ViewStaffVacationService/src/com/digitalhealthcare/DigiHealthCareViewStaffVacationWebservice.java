package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigiHealthCareViewStaffVacationWebservice {

	public CISResults viewStaffVacation(String staffId) {
		DigiHealthCareViewStaffVacationBL viewStaffVacationBL = new DigiHealthCareViewStaffVacationBL();
		 Logger logger = Logger.getLogger(ViewMessagesWebservice.class);
		 CISResults cisResult = viewStaffVacationBL.viewStaffVacation(staffId);
		 logger.info("  view staff vacation webservice :"+cisResult);
		return cisResult;
	}

}