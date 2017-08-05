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
public class DigiHealthCareViewStaffAvilabiltyBL {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigiHealthCareViewStaffAvilabiltyDAO viewStaffAvilabiltyDAO=(DigiHealthCareViewStaffAvilabiltyDAO)ctx.getBean("ViewStaffAvilabilty");


	public CISResults viewstaffAvilabilty(String staffId) {
		final Logger logger = Logger.getLogger(DigiHealthCareViewStaffAvilabiltyBL.class);
		
		CISResults cisResult = viewStaffAvilabiltyDAO.viewstaffAvilabilty(staffId);
		logger.info("DigitalHealthCare:view staff availability BL  service" +cisResult );
		return cisResult;
	}
	

}
