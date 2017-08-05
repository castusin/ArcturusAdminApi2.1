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
 * Rest Controller : view messages Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareDeletestaffAvilabiltyRest {
	
	@RequestMapping(value="/deletestaffAvilabilty",method=RequestMethod.GET,produces={"application/json"})

	 public String deletestaffAvilabilty(HttpServletRequest request,@RequestParam ("availabilityId") String availabilityId){
		    Logger logger = Logger.getLogger(DigiHealthCareViewstaffAvilabiltyRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.deletestaffAvilabiltyValidation(request,availabilityId);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigiHealthCareDeletestaffAvilabiltyWebservice deletestaffAvilabiltyWebservice= new DigiHealthCareDeletestaffAvilabiltyWebservice();
		    	cisResults  = deletestaffAvilabiltyWebservice.deletestaffAvilabilty(availabilityId);
		    	logger.info(" DigitalHealthCare: delete staff Avilabilty service :"+cisResults);
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
