
package com.digitalhealthcare;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
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
         String startTime="9:00:00 am";  
         String endTime="10:00:00 am";
         String startDateTime=smartAppointment.getStartDateTime();
         
       
         String patientId=smartAppointment.getPatientId();        
         String aptWith=smartAppointment.getAptWith();                   
         int staffId=smartAppointment.getStaffId();  
         
         // week dates from  a given date
         SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy HH:hh:ss");
    	 Date startdate = sdf.parse(startDateTime);
         Calendar cal = Calendar.getInstance();
         cal.setTime(startdate );//Set specific Date if you want to
         StringBuilder stringBuilder = new StringBuilder();
         for(int p = 0; p < 7; p++){
             System.out.println(cal.getTime());
             cal.add(Calendar.DATE, 1);
            // StringBuilder stringBuilder = new StringBuilder();
			 stringBuilder.append(cal.getTime());
			
        
         String finalString = stringBuilder.toString();
         
         // staff with service type
         List<StaffModel> staffList = smartAppointmentDAO.getStaffAvailable(serviceType);
         
         ArrayList<Object> staffDetails = new ArrayList<Object>();
		 for (int i = 0; i < staffList.size(); i++) {
			 
			 StaffModel staffModel = new StaffModel();
			 
			 String servicetype= staffList.get(i).serviceType;
			 int staffid=staffList.get(i).staffId;
			 String staffFirstname=staffList.get(i).fName;
			 String staffLastname=staffList.get(i).lName;
			 String weekday=staffList.get(i).weekday;
			 staffModel.setServiceType(servicetype);
			 staffModel.setStaffId(staffid);
			 staffModel.setfName(staffFirstname);
			 staffModel.setlName(staffLastname);
			 staffModel.setWeekday(weekday);
			 staffDetails.add(staffModel);
			 cisResults = smartAppointmentDAO.getStaffVacation(staffid,finalString);
			 
			 if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
			   {
				  	cisResults = smartAppointmentDAO.getStaffAppt(staffid,finalString);
				 	
				  	if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE)){
				  		
				  		 ArrayList<Object> appointments = new ArrayList<Object>();
			             for (int s = 0; s < staffList.size(); s++) {
			                 
			            	 StaffModel staff = new StaffModel();
			            	 
			            	 
			            	 
			            	 String Servicetype= staffList.get(s).serviceType;
			    			 int Staffid=staffList.get(s).staffId;
			    			 String StaffFirstname=staffList.get(s).fName;
			    			 String StaffLastname=staffList.get(s).lName;
			    			 String StartTime=staffList.get(s).startTime;
			    			 String EndTime=staffList.get(s).endTime;
			    			 String weekDay=staffList.get(s).weekday;
			    			 staff.setServiceType(Servicetype);
			    			 staff.setStaffId(Staffid);
			    			 staff.setfName(StaffFirstname);
			    			 staff.setlName(StaffLastname);
			    			 staff.setStartTime(StartTime);
			    			 staff.setWeekday(weekDay);
			                 staff.setEndTime(EndTime);
			            
			             appointments.add(staff);
					}
					
					 cisResults.setResultObject(appointments);
				 		
						/* stringBuilders.append(staffid);
						 stringBuilders.append(aptWith);
						 stringBuilders.append(startDateTime);*/
						 
				 	}
				  		/*String finalStrings = stringBuilders.toString();
				  		System.out.println(finalStrings);
				  		cisResults.setResultObject(finalStrings);*/
			   }
				 
			}
			 
		 }
         
         return cisResults;
         
        /* cisResults = smartAppointmentDAO.getPatientDetails(patientId);
         
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
		
       	    
		    // Capture Service End time
         String serviceEndTime=time.getTimeZone();
         long result=seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
         logger.info("Database time for save staff availability  service:: " +result );
         
         return cisResults;
         }*/
        
     }
}