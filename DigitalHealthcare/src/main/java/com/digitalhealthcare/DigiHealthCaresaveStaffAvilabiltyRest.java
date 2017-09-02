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
 * Rest Controller : create staff schedule Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCaresaveStaffAvilabiltyRest {
	
	
	@RequestMapping(value="/saveStaffAvailability",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String saveStaffAvailability(@RequestBody DigiHealthCaresaveStaffAvilabiltyModel saveStaff,HttpServletRequest request) throws Throwable{
		 
		Logger logger = Logger.getLogger(DigiHealthCaresaveStaffAvilabiltyRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.saveStaffAvailabilityValidation(saveStaff,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
			   	DigiHealthCaresaveStaffAvilabiltyWebservice saveStaffAvilabiltyWebservice= new DigiHealthCaresaveStaffAvilabiltyWebservice();
			   	cisResults  = saveStaffAvilabiltyWebservice.saveStaffAvailability(saveStaff);
		       logger.info(" DigitalHealthCare: saveStaffAvilabilty rest service :"+cisResults);
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
