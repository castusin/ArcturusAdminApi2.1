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
       
         String startDateTime=smartAppointment.getStartDateTime();
         
       
         String patientId=smartAppointment.getPatientId();        
         String aptWith=smartAppointment.getAptWith();                   
         int staffId=smartAppointment.getStaffId();  
         String finalString;
         String endDateTime = "";
         
         // week dates from  a given date
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	 Date startdate = sdf.parse(startDateTime);
         Calendar cal = Calendar.getInstance();
         cal.setTime(startdate );//Set specific Date if you want to
         StringBuilder stringBuilder = new StringBuilder();
         ArrayList<Object> hoursList = new ArrayList<Object>(); 
         hoursList.add("09:00 am,10:00 am");
         hoursList.add("10:00 am,11:00 am");
         hoursList.add("11:00 am,12:00 pm");
         hoursList.add("12:00 pm,01:00 pm");
         hoursList.add("01:00 pm,02:00 pm");
         hoursList.add("02:00 pm,03:00 pm");
         hoursList.add("03:00 pm,04:00 pm");
         hoursList.add("04:00 pm,05:00 pm");
         hoursList.add("05:00 pm,06:00 pm");
         
         for(int p = 0; p < 7; p++){
        	 if(p==0){
        		 System.out.println(cal.getTime());
        		 stringBuilder.append(cal.getTime());
        		 
        	 }
        	 if(p>0){
        		 stringBuilder.setLength(0);
        		 System.out.println(cal.getTime());
        		 cal.add(Calendar.DATE, 1);
        		 stringBuilder.append(cal.getTime());
        	 }
        	 
        	 finalString = stringBuilder.toString();
         
         // split time
             String[] allStrings = finalString.split("\\s");
         
         for (int j = 0; j < allStrings.length-3; j++){
             endDateTime = endDateTime + " " + allStrings[j];
             endDateTime=endDateTime.trim();
           
         }
         
         int staffid=0;
         
         for(int i=0;i<=8;i++)
         {
        	 String availbilityHours = hoursList.get(i).toString();
        	 String[] namesList = availbilityHours.split(",");
        	 String startHour = namesList[0];
        	 String endHour = namesList[1];
        	//conversion from 12 hour to 24 hour
        	 SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
             SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
             Date date = parseFormat.parse(startHour);
             System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
             String starttime=displayFormat.format(date);
             
             Date dates = parseFormat.parse(endHour);
             System.out.println(parseFormat.format(dates) + " = " + displayFormat.format(dates));
             String endtime=displayFormat.format(dates);
        	//String s=endDateTime.concat( startHour);
        	 
             // appending time
        	 String result = new StringBuilder().append(endDateTime).append(" ").append("2017").append(" ").append(" ").append(starttime).toString();

        		cisResults = smartAppointmentDAO.getPatientAvailable(patientId,result);
         	
        	if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
      		   {
        		
        	 
        	 
             List<StaffModel> staffList = smartAppointmentDAO.getStaffAvailable(serviceType,starttime,endtime,startDateTime);
                
             ArrayList<Object> staffDetails = new ArrayList<Object>();
       		 for (int s = 0; s < staffList.size(); s++) {
       			 
       			 StaffModel staffModel = new StaffModel();
       			 
       			 String servicetype= staffList.get(s).serviceType;
       			  staffid=staffList.get(s).staffId;
       			 String staffFirstname=staffList.get(s).fName;
       			 String staffLastname=staffList.get(s).lName;
       			 String weekday=staffList.get(s).weekday;
       			 staffModel.setServiceType(servicetype);
       			 staffModel.setStaffId(staffid);
       			 staffModel.setfName(staffFirstname);
       			 staffModel.setlName(staffLastname);
       			 staffModel.setWeekday(weekday);
       			 staffDetails.add(staffModel);
       		 }
       		 
       		 
       		 
       			 cisResults = smartAppointmentDAO.getStaffVacation(staffid,startDateTime);
       			 
       			 /*if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE))
       			   {
       				  	cisResults = smartAppointmentDAO.getStaffAppt(staffid,finalString);
       				 	
       				  	if(cisResults.getResponseCode().equalsIgnoreCase(CISConstants.RESPONSE_FAILURE)){
       				  		
       				  		 ArrayList<Object> appointments = new ArrayList<Object>();
       			             for (int s1 = 0; s1 < staffList.size(); s1++) {
       			                 
       			            	 StaffModel staff = new StaffModel();
       			            	 
       			            	 String Servicetype= staffList.get(s1).serviceType;
       			    			 int Staffid=staffList.get(s1).staffId;
       			    			 String StaffFirstname=staffList.get(s1).fName;
       			    			 String StaffLastname=staffList.get(s1).lName;
       			    			 String StartTime=staffList.get(s1).startTime;
       			    			 String EndTime=staffList.get(s1).endTime;
       			    			 String weekDay=staffList.get(s1).weekday;
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
       				 	 cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS );
       						 stringBuilders.append(staffid);
       						 stringBuilders.append(aptWith);
       						 stringBuilders.append(startDateTime);
       						 
       				 	}
       				  		String finalStrings = stringBuilders.toString();
       				  		System.out.println(finalStrings);
       				  		cisResults.setResultObject(finalStrings);
       			   }
       			*/	 
       			}
        	 
        	 
        	 
        	 
         }
          
         
         
         
         
         // staff with service type
        /* List<StaffModel> staffList = smartAppointmentDAO.getStaffAvailable(serviceType);
         
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
				 	 cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS );
						 stringBuilders.append(staffid);
						 stringBuilders.append(aptWith);
						 stringBuilders.append(startDateTime);
						 
				 	}
				  		String finalStrings = stringBuilders.toString();
				  		System.out.println(finalStrings);
				  		cisResults.setResultObject(finalStrings);
			   }
				 
			}*/
			 
		 }
         
         return cisResults;
         
         
        
     }
}
