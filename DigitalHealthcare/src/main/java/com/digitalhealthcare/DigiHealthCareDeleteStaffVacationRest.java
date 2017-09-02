package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


/**
 * Rest Controller : delete vacation Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareDeleteStaffVacationRest {
	
	@RequestMapping(value="/deleteStaffVacation",method=RequestMethod.GET,produces={"application/json"})

	 public String deleteStaffVacation(HttpServletRequest request,@RequestParam ("vacationId") String vacationId){
		    Logger logger = Logger.getLogger(DigiHealthCareDeleteStaffVacationRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.deleteStaffVacationValidation(request,vacationId);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigiHealthCareDeleteStaffVacationWebservice deleteStaffVacationWebservice= new DigiHealthCareDeleteStaffVacationWebservice();
		    	cisResults  = deleteStaffVacationWebservice.deleteStaffVacation(vacationId);
		    	logger.info(" DigitalHealthCare: delete staff vacation service :"+cisResults);
		     }
		       return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
}
