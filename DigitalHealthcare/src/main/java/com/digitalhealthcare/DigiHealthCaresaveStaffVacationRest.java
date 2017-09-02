package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;


/**
 * Rest Controller : save staff vacation Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCaresaveStaffVacationRest {
	
	
	@RequestMapping(value="/saveStaffVacation",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String saveStaffVacation(@RequestBody DigiHealthCaresaveStaffVacationModel saveStaffVacation,HttpServletRequest request) throws Throwable{
		 
		Logger logger = Logger.getLogger(DigiHealthCaresaveStaffVacationRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.saveStaffVacaionValidation(saveStaffVacation,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
		    	DigiHealthCaresaveStaffVacationWebservice saveStaffVacaionWebservice= new DigiHealthCaresaveStaffVacationWebservice();
			   	cisResults  = saveStaffVacaionWebservice.saveStaffVacation(saveStaffVacation);
		       logger.info(" DigitalHealthCare: saveStaffVacation rest service :"+cisResults);
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
