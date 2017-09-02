package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.SMSCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCareEditStaffAvilabiltyBL {

     ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
     DigiHealthCareEditStaffAvilabiltyDAO editStaffAvilabiltyDAO=(DigiHealthCareEditStaffAvilabiltyDAO)ctx.getBean("EditStaffAvilabilty");
    
     
     public CISResults editStaffAvilabilty(DigiHealthCaresaveStaffAvilabiltyModel editStaff) throws Throwable{
        
        final Logger logger = Logger.getLogger(DigiHealthCaresaveStaffAvilabiltyBL.class);
        // Capture service Start time
        
         CISResults cisResults=new CISResults();
         TimeCheck time=new TimeCheck();
         testServiceTime seriveTimeCheck=new testServiceTime();
         String serviceStartTime=time.getTimeZone();
         
          String starttime="";
          String endtime="";
          String availFlag="";
          String staffid="";
          String weekName="";
          String creationtime="";
          String date="";
          String availId="";
         
          int aptListSize=editStaff.getStaffList().size();
          for (int i = 0; i< aptListSize; i++)
		  {
        	  
        	  
        	  availId= editStaff.getStaffList().get(i).availabilityId;
        	  
			  
			  //staffid =  editStaff.getStaffList().get(i).staffId;
			  weekName =  editStaff.getStaffList().get(i).weekdayName;
			  starttime =  editStaff.getStaffList().get(i).startTime;
			  endtime =  editStaff.getStaffList().get(i).endTime;
			 // creationtime =  saveStaff.getStaffList().get(i).createDatetime;
			  Calendar currentdate = Calendar.getInstance();
	          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	          formatter.setTimeZone(obj);
	          String createDate=time.getTimeZone();
			  cisResults = editStaffAvilabiltyDAO.editStaffAvilabilty(availId,staffid,weekName,starttime,endtime,createDate);
		         
			  
		  }
         // Capture Service End time
          String serviceEndTime=time.getTimeZone();
          long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
          logger.info("Database time for save staff availability  service:: " +result );
         
        return cisResults;
         }

	
}