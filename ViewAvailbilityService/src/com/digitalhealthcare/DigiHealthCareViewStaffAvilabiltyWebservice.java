package com.digitalhealthcare;
import org.apache.log4j.Logger;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigiHealthCareViewStaffAvilabiltyWebservice {

	public CISResults viewstaffAvilabilty(String staffId) {
		DigiHealthCareViewStaffAvilabiltyBL viewStaffAvilabiltyBL = new DigiHealthCareViewStaffAvilabiltyBL();
		 Logger logger = Logger.getLogger(DigiHealthCareViewStaffAvilabiltyWebservice.class);
		 CISResults cisResult = viewStaffAvilabiltyBL.viewstaffAvilabilty(staffId);
		 logger.info("  view staff availability webservice :"+cisResult);
		return cisResult;
	}

}
