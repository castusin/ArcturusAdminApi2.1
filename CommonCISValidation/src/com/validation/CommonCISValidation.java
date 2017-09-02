package com.validation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.digitalhealthcare.DigiHealthCaresaveStaffAvilabiltyModel;
import com.digitalhealthcare.DigiHealthCaresaveStaffVacationModel;
import com.digitalhealthcare.SmartAppointmentModel;
import com.digitalhealthcare.ViewMessagesModel;


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

	public CISResults viewMessagesValidation(HttpServletRequest request,
			ViewMessagesModel viewMessages) {


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

	public CISResults smartAppointmentServiceValidation(
			SmartAppointmentModel smartAppointment,
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

	public CISResults saveStaffVacaionValidation(
			DigiHealthCaresaveStaffVacationModel saveStaffVacation,
			HttpServletRequest request) {


		CISResults cisResult=new CISResults();
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
	   
	   
	    return cisResult;
	}

	public CISResults viewStaffVacationValidation(HttpServletRequest request,
			String staffId) {
		CISResults cisResult=new CISResults();
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
	   
	   
	    return cisResult;
	}

	public CISResults editStaffAvilabiltyValidation(
			DigiHealthCaresaveStaffAvilabiltyModel editStaff,
			HttpServletRequest request) {
		CISResults cisResult=new CISResults();
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
	   
	   
	    return cisResult;
	}

	public CISResults editStaffVacationValidation(
			DigiHealthCaresaveStaffVacationModel editStaffVacation,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		CISResults cisResult=new CISResults();
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
	   
	   
	    return cisResult;
	}

	public CISResults deleteStaffVacationValidation(HttpServletRequest request,
			String vacationId) {
		// TODO Auto-generated method stub

		CISResults cisResult=new CISResults();
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
	   
	   
	    return cisResult;
	}




}
