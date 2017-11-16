package com.digitalhealthcare;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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


	public CISResults viewstaffAvilabilty(String staffId) throws Throwable {
		final Logger logger = Logger.getLogger(DigiHealthCareViewStaffAvilabiltyBL.class);
		CISResults cisResult=new CISResults();
		 List<AddAvailability> staffList = viewStaffAvilabiltyDAO.viewstaffAvilabilty(staffId);
		
		  ArrayList<Object> staffDetails = new ArrayList<Object>();
    		 for (int s = 0; s < staffList.size(); s++) {
    			 
    			 AddAvailability staffModel = new AddAvailability();
    			 
    			 
    			 String availabilityId=staffList.get(s).availabilityId;
    			 staffModel.setAvailabilityId(availabilityId);
    			 String starttime= staffList.get(s).startTime;
    			 
    			 if(starttime.equalsIgnoreCase("")){
    				 
    				 String weekday=staffList.get(s).weekdayName;
    	    			
        			 staffModel.setStartTime(starttime);
        			 String endtime=staffList.get(s).endTime;
        			 staffModel.setEndTime(endtime);
        			 
        			 staffModel.setWeekdayName(weekday);
        			 staffDetails.add(staffModel);
    				 
    			 }else{
    				 
    			 	SimpleDateFormat displayFormat = new SimpleDateFormat("hh:mm a");
    			 	SimpleDateFormat parseFormat = new SimpleDateFormat("HH:mm:ss");
    			 	java.util.Date dates = parseFormat.parse(starttime);
    			 	System.out.println(parseFormat.format(dates) + " = " + displayFormat.format(dates));
    			 	starttime=displayFormat.format(dates);
    			
    			 String endtime=staffList.get(s).endTime;
    			 	java.util.Date endates = parseFormat.parse(endtime);
    			 	System.out.println(parseFormat.format(endates) + " = " + displayFormat.format(endates));
    			 	endtime=displayFormat.format(endates);
    			
    			 String weekday=staffList.get(s).weekdayName;
    			
    			 staffModel.setStartTime(starttime);
    			 staffModel.setEndTime(endtime);
    			 
    			 staffModel.setWeekdayName(weekday);
    			staffModel.setAvailabilityId(availabilityId);
    		
	            
	             staffDetails.add(staffModel);
    		 }
    	}
    		 cisResult.setResultObject(staffDetails);
		logger.info("DigitalHealthCare:view staff availability BL  service" +cisResult );
		return cisResult;
	}
	

}
