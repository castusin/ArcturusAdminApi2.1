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

@RestController
public class DigiHealthCareSmartAppointmentRest {
	
	
	@RequestMapping(value="/smartAppointmentService",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String smartAppointmentService(@RequestBody SmartAppointmentModel smartAppointment,HttpServletRequest request) throws Throwable{
		 
		Logger logger = Logger.getLogger(DigiHealthCareSmartAppointmentRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		    CISResults cisResults=CommonCISValidation.smartAppointmentServiceValidation(smartAppointment,request);
		    if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    {
		    	SmartAppointmentWebservice smartAppointmentWebservice= new SmartAppointmentWebservice();
			   	cisResults  = smartAppointmentWebservice.smartAppointmentService(smartAppointment);
		       logger.info(" DigitalHealthCare: smartAppointment rest service :"+cisResults);
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
