
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
public class DigiHealthCareViewstaffAvilabiltyRest {
	
	@RequestMapping(value="/viewstaffAvilabilty",method=RequestMethod.GET,produces={"application/json"})

	 public String viewstaffAvilabilty(HttpServletRequest request,@RequestParam ("staffId") String staffId){
		    Logger logger = Logger.getLogger(DigiHealthCareViewstaffAvilabiltyRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.viewstaffAvilabiltyValidation(request,staffId);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		     {
		    	DigiHealthCareViewStaffAvilabiltyWebservice viewStaffAvilabiltyWebservice= new DigiHealthCareViewStaffAvilabiltyWebservice();
		    	cisResults  = viewStaffAvilabiltyWebservice.viewstaffAvilabilty(staffId);
		       logger.info(" DigitalHealthCare: View staff Avilabilty service :"+cisResults);
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
