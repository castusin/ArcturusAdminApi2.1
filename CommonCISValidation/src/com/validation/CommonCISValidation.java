package com.validation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigiHealthCaresaveStaffAvilabiltyModel;


public class CommonCISValidation {
	
	public CISResults saveStaffAvailabilityValidation(
			DigiHealthCaresaveStaffAvilabiltyModel saveStaff,
			HttpServletRequest request) {


		CISResults cisResult=new CISResults();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
		return cisResult;
	}

	public CISResults viewstaffAvilabiltyValidation(HttpServletRequest request,
			String staffId) {


		CISResults cisResult=new CISResults();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
		return cisResult;
	}

	public CISResults deletestaffAvilabiltyValidation(
			HttpServletRequest request, String availabilityId) {


		CISResults cisResult=new CISResults();
		ArrayList<String> emptyValidatonArray= new ArrayList<String>();
		cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		String headerAuthorization=request.getHeader(CISConstants.HEADERS_AUTHROIZATION);
	        //Validate Headers AUTHROIZATION
	   if(headerAuthorization.equals(CISConstants.HEADERS_AUTHROIZATION_VAUE))
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_SUCCESS);
	         }else
	         {
		               cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
	          }
	   
	   
	        // Validate Null Values 
	   if(cisResult.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_SUCCESS))
		  {
	   
			 for (String st : emptyValidatonArray) {
		            if  (st==null || st.equals(""))
		            	cisResult.setResponseCode(CISConstants.RESPONSE_FAILURE);
		          } 
		  }
		return cisResult;
	}

}
