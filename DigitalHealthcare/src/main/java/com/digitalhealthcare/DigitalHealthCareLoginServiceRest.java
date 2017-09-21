package com.digitalhealthcare;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cis.CISResults;
import com.google.gson.Gson;



@RestController
public class DigitalHealthCareLoginServiceRest {
	
	@RequestMapping(value="/loginService", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	
	public String login(HttpServletRequest request,@RequestParam ("adminUserName") String adminUserName, @RequestParam ("Password") String Password) throws Throwable{
		
		// if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
				 // {
				     DigitalHealthCareLoginWebservice loginService= new DigitalHealthCareLoginWebservice();
				     CISResults cisResult  = loginService.login(adminUserName,Password);
				//  }
				     return returnJsonData(cisResult);
				  
				  
					 }
			 private String returnJsonData(Object src){
					// TODO Auto-generated method stub
			        Gson gson = new Gson();
					String feeds = gson.toJson(src);
					return feeds;
				}
			
		}

		

