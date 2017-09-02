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
 * Rest Controller : edit staff schedule Service
 * 
 * @author Castus Info Solutions
 * 
 *  
 * 
 * 
 * 
 */
@RestController
public class DigiHealthCareEditStaffAvilabiltyRest {
	
	
	@RequestMapping(value="/editStaffAvilability",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String editStaffAvilabilty(@RequestBody DigiHealthCaresaveStaffAvilabiltyModel editStaff,HttpServletRequest request) throws Throwable{
		 
		Logger logger = Logger.getLogger(DigiHealthCareEditStaffAvilabiltyRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.editStaffAvilabiltyValidation(editStaff,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
		    	DigiHealthCareEditStaffAvilabiltyWebservice editStaffAvilabiltyWebservice= new DigiHealthCareEditStaffAvilabiltyWebservice();
			   	cisResults  = editStaffAvilabiltyWebservice.editStaffAvilabilty(editStaff);
		       logger.info(" DigitalHealthCare: edit StaffAvilabilty rest service :"+cisResults);
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
