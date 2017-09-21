package com.digitalhealthcare;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISResults;

public class DigitalHealthCareLoginBL {
	
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	DigitalHealthCareLoginDAO loginDAO=(DigitalHealthCareLoginDAO)ctx.getBean("login");

	
	public CISResults login(String userName, String password) throws Throwable {
		
	
        	 
		CISResults cisResult = loginDAO.login(userName,password);
		
		/*DigitalHealthCareSessions  log=(DigitalHealthCareSessions)cisResult.getResultObject();
        String adminid=log.getAdminId();*/
		 
		return cisResult;

}
}

