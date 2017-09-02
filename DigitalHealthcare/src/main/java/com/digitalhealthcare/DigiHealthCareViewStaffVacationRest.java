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
 * Rest Controller : view staff vacation Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareViewStaffVacationRest {
	
	@RequestMapping(value="/viewStaffVacation",method=RequestMethod.GET,produces={"application/json"})

	 public String viewStaffVacation(HttpServletRequest request,@RequestParam ("staffId") String staffId){
		    Logger logger = Logger.getLogger(DigiHealthCareViewMessagesRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.viewStaffVacationValidation(request,staffId);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigiHealthCareViewStaffVacationWebservice viewStaffVacationWebservice= new DigiHealthCareViewStaffVacationWebservice();
		        cisResults  = viewStaffVacationWebservice.viewStaffVacation(staffId);
		        logger.info(" DigitalHealthCare: viewStaffVacation  service :"+cisResults);
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