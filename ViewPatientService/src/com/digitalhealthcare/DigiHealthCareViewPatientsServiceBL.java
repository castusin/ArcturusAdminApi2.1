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


public class DigiHealthCareViewPatientsServiceBL {

	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareViewPatientsServiceDAO viewPatientsServiceDAO=(DigiHealthCareViewPatientsServiceDAO)ctx.getBean("viewPatients");

	public CISResults viewPatients(String staffId){
		final Logger logger = Logger.getLogger(DigiHealthCareViewPatientsServiceBL.class);
		CISResults cisResult = viewPatientsServiceDAO.viewPatientdetails(staffId);
		logger.info("DigitalHealthCare:view patient details BL  service" +cisResult );
		return cisResult;
	}


}