package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class DigiHealthCaresaveStaffAvilabiltyBL {

     ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
     DigiHealthCaresaveStaffAvilabiltyDAO saveStaffAvilabiltyDAO=(DigiHealthCaresaveStaffAvilabiltyDAO)ctx.getBean("StaffAvilabilty");
    
     
     public CISResults saveStaffAvailability(DigiHealthCaresaveStaffAvilabiltyModel saveStaff) throws Throwable{
        
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
         
          int aptListSize=saveStaff.getStaffList().size();
          for (int i = 0; i< aptListSize; i++)
		  {
        	  String sessionId = UUID.randomUUID().toString();
              String availabilityId=DigestUtils.sha1Hex(sessionId);
              String upToNCharacters = availabilityId.substring(0, Math.min(availabilityId.length(), 8));
              availabilityId=upToNCharacters;
        	  //availId= saveStaff.getStaffList().get(i).availabilityId;
        	  
			  
			  staffid =  saveStaff.getStaffList().get(i).staffId;
			  weekName =  saveStaff.getStaffList().get(i).weekdayName;
			  starttime =  saveStaff.getStaffList().get(i).startTime;
			  endtime =  saveStaff.getStaffList().get(i).endTime;
			  if(starttime.equalsIgnoreCase("")){
				  Calendar currentdate = Calendar.getInstance();
		          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		          formatter.setTimeZone(obj);
		          String createDate=time.getTimeZone();
				  
				  cisResults = saveStaffAvilabiltyDAO.saveStaffAvailability(availabilityId,staffid,weekName,starttime,endtime,createDate);
				    
				  
			  }else{
				  
			  		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
			  		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
			  		Date dates = parseFormat.parse(starttime);
			  		System.out.println(parseFormat.format(dates) + " = " + displayFormat.format(dates));
			  		 starttime=displayFormat.format(dates);
			  endtime =  saveStaff.getStaffList().get(i).endTime;
			  
			  		Date endates = parseFormat.parse(endtime);
			  		System.out.println(parseFormat.format(endates) + " = " + displayFormat.format(endates));
			  		 endtime=displayFormat.format(endates);
			 // creationtime =  saveStaff.getStaffList().get(i).createDatetime;
			  Calendar currentdate = Calendar.getInstance();
	          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
	          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
	          formatter.setTimeZone(obj);
	          String createDate=time.getTimeZone();
	              
			  cisResults = saveStaffAvilabiltyDAO.saveStaffAvailability(availabilityId,staffid,weekName,starttime,endtime,createDate);
			  }    
			  
		  }
         // Capture Service End time
          String serviceEndTime=time.getTimeZone();
          long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
          logger.info("Database time for save staff availability  service:: " +result );
         
        return cisResults;
         }

	
}