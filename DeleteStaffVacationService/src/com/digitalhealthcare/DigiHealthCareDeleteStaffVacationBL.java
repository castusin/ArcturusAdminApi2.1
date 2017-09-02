package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareDeleteStaffVacationBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareDeleteStaffVacationDAO deleteStaffVacationDAO=(DigiHealthCareDeleteStaffVacationDAO)ctx.getBean("DeleteStaffVacation");

	public CISResults deleteStaffVacation(String vacationId){
		
		final Logger logger = Logger.getLogger(DigiHealthCareDeleteStaffVacationBL.class);
		// Capture service Start time
	  	 TimeCheck time=new TimeCheck();
		 testServiceTime seriveTimeCheck=new testServiceTime();
		 String serviceStartTime=time.getTimeZone();
		 CISResults cisResult = deleteStaffVacationDAO.deleteStaffVacation(vacationId);
		// Capture Service End time
		 String serviceEndTime=time.getTimeZone();
		 long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
	     logger.info("Database time for delete staff vacation service:: " +result );
		  
		return cisResult;
	}


}