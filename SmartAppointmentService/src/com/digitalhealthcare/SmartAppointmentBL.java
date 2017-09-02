
package com.digitalhealthcare;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.EmailCommunication;
import com.cis.TimeCheck;
import com.cis.testServiceTime;


public class SmartAppointmentBL {

     ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
     SmartAppointmentDAO smartAppointmentDAO=(SmartAppointmentDAO)ctx.getBean("SmartAppointment");
    
     
     public CISResults smartAppointmentService(SmartAppointmentModel smartAppointment) throws Throwable{
        
         final Logger logger = Logger.getLogger(SmartAppointmentBL.class);
        // Capture service Start time
       
         CISResults cisResults=new CISResults();
         TimeCheck time=new TimeCheck();
         testServiceTime seriveTimeCheck=new testServiceTime();
         String serviceStartTime=time.getTimeZone();
       
         String serviceType=smartAppointment.getServiceType();           
         String startDateTime=smartAppointment.getStartDateTime();  
         SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
         Date startdate=simpleDate.parse(startDateTime);
         
       //  String reportDate = simpleDate.format(startdate);

         String patientId=smartAppointment.getPatientId();        
         String aptWith=smartAppointment.getAptWith();                   
         String staffId=smartAppointment.getStaffId();  
         
         SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
         System.out.println(simpleDateformat.format(startdate));
  
        
         
         if(serviceType.equalsIgnoreCase(CISConstants.CNA)){
        	   
        	   smartAppointment.setAptWith(aptWith);
        	   smartAppointment.setStartDateTime(startDateTime);
        	   smartAppointment.setPatientId(patientId);
        	   smartAppointment.setStaffId(staffId);
          }
          //  cisResults = smartAppointmentDAO.smartAppointmentService(serviceType,patientId,aptWith,staffId,startDateTime);
         // Capture Service End time
         String serviceEndTime=time.getTimeZone();
         long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
         logger.info("Database time for save staff availability  service:: " +result );
         
         return cisResults;
         }

	
}