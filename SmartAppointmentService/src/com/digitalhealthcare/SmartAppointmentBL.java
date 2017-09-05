
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
         
         
         cisResults = smartAppointmentDAO.getPatientDetails(patientId);
         
         PatientModel  patientLat=(PatientModel)cisResults.getResultObject();
		 	float patientLattitude=patientLat.getLattitude();
		 
		 	PatientModel  patientLong=(PatientModel)cisResults.getResultObject();
			float patientLongitude=patientLong.getLongitude();
			
        cisResults = smartAppointmentDAO.getStaffDetails(staffId);
         
            StaffModel  staffLat=(StaffModel)cisResults.getResultObject();
			float staffLattitude=staffLat.getLattitude();
		 
			StaffModel  stafffLong=(StaffModel)cisResults.getResultObject();
			float staffLongitude=stafffLong.getLongitude();
			
			double earthRadius = 6371000; //meters
		    double dLat = Math.toRadians(staffLattitude-patientLattitude);
		    double dLng = Math.toRadians(staffLongitude-patientLongitude);
		    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		               Math.cos(Math.toRadians(patientLattitude)) * Math.cos(Math.toRadians(staffLattitude)) *
		               Math.sin(dLng/2) * Math.sin(dLng/2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		    float dist = (float) (earthRadius * c);
		    System.out.println(dist);
		/*	Location loc1 = new Location("");
			loc1.setLatitude(lat1);
			loc1.setLongitude(lon1);

			Location loc2 = new Location("");
			loc2.setLatitude(lat2);
			loc2.setLongitude(lon2);

			float distanceInMeters = loc1.distanceTo(loc2);*/
         
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