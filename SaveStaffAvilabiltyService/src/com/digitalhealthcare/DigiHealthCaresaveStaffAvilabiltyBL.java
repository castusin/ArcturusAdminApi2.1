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
         
         // generating id
         
         String sessionId = UUID.randomUUID().toString();
         String availabilityId=DigestUtils.sha1Hex(sessionId);
         String upToNCharacters = availabilityId.substring(0, Math.min(availabilityId.length(), 8));
         availabilityId=upToNCharacters;
        
          Calendar currentdate = Calendar.getInstance();
          DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
          TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
          formatter.setTimeZone(obj);
          String createDate=time.getTimeZone();
      
          cisResults = saveStaffAvilabiltyDAO.saveStaffAvailability(availabilityId,saveStaff.getStaffId(),saveStaff.getAvailabilityFlag(),saveStaff.getWeekdayName(),saveStaff.getDate(),saveStaff.getStartTime(),saveStaff.getEndTime(),createDate);
              
        // Capture Service End time
          String serviceEndTime=time.getTimeZone();
          long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
          logger.info("Database time for save staff availability  service:: " +result );
         
        return cisResults;
         }

	
}