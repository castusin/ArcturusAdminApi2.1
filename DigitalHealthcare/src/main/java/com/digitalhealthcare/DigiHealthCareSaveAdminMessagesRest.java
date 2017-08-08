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
public class DigiHealthCareSaveAdminMessagesRest {
	
	
	@RequestMapping(value="/saveAdminMessages",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public String saveAdminMessages(HttpServletRequest request,@RequestBody DigiHealthCareSaveAdminMessagesModel saveMessages) throws Throwable{
		 
		Logger logger = Logger.getLogger(DigiHealthCareSaveAdminMessagesRest.class);
			
            CommonCISValidation CommonCISValidation=new CommonCISValidation();
		   // CISResults cisResults=CommonCISValidation.saveStaffMemberValidation(request,saveStaffmember);
		    //if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		    // {
            DigiHealthCareSaveAdminMessagesWebservice saveAdminMessagesWebservice= new DigiHealthCareSaveAdminMessagesWebservice();
		    	CISResults cisResults  = saveAdminMessagesWebservice.saveAdminMessages(saveMessages);
		        logger.info(" DigitalHealthCare: save staff member rest service :"+cisResults);
		    // }
		       return returnJsonData(cisResults);
	 }
	 
	 
	 private String returnJsonData(Object src){
			// TODO Auto-generated method stub
	        Gson gson = new Gson();
			String feeds = gson.toJson(src);
			return feeds;
		}
}
