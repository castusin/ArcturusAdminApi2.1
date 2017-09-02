package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;
import com.google.gson.Gson;
import com.validation.CommonCISValidation;

@RestController
public class DigiHealthCareViewPatientsRestService {

	
	
	@RequestMapping(value="/viewPatients",method=RequestMethod.GET,produces={"application/json"})
	
		public String viewPatients(HttpServletRequest request, @RequestParam ("patientId") String patientId){	 
		 Logger logger = Logger.getLogger(DigiHealthCareViewPatientsRestService.class);
		 DigiHealthCareViewPatientsServiceWebservice viewPatientsservice= new DigiHealthCareViewPatientsServiceWebservice();
		 CISResults cisResults  = viewPatientsservice.viewPatients(patientId);
		 logger.info(" DigitalHealthCare: View Patient details :"+cisResults);
		   
		return returnJsonData(cisResults);
	 }
	 	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
	
}
