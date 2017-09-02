package com.digitalhealthcare;

import java.sql.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

/**
 * @author 
 *
 */
public class DigiHealthCareViewStaffVacationBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareViewStaffVacationDAO viewStaffVacationDAO=(DigiHealthCareViewStaffVacationDAO)ctx.getBean("ViewStaffVacation");


	public CISResults viewStaffVacation(String  staffId) {
		final Logger logger = Logger.getLogger(ViewMessagesBL.class);
		CISResults cisResult = viewStaffVacationDAO.viewStaffVacation(staffId);
		logger.info("DigitalHealthCare:view staff vacation BL  service" +cisResult );
		return cisResult;
	}
	

}