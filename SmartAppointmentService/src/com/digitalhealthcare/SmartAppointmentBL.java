package com.digitalhealthcare;





import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Date;

import java.util.Iterator;

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

    

     

     /**

     * @param smartAppointment

     * @return

     * @throws Throwable

     */

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

         String appointmentDate = "";

         String endDateTime = "";

         int i = 0;

         

         // week dates from  a given date

         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    	 Date startdate = sdf.parse(startDateTime);

         Calendar cal = Calendar.getInstance();

         cal.setTime(startdate );//Set specific Date if you want to

         StringBuilder stringBuilder = new StringBuilder();

         ArrayList<Object> hoursList = new ArrayList<Object>(); 

         ArrayList<StaffModel> appointmentCoordinates = new ArrayList<StaffModel>();

         List<StaffModel> staffList = new ArrayList<StaffModel>();

         ArrayList<Object> smartAppointmentList = new ArrayList<Object>();

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

        		 finalString = stringBuilder.toString();

        		 

        		 SimpleDateFormat parseFormat = 

        				    new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

        				Date date = parseFormat.parse(finalString);

        				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        				appointmentDate = format.format(date);

        		       System.out.println(" appointmentDate : "+appointmentDate);

        		 

        		 

        		 

        		 

        	 }

        	 if(p>0){

        		 stringBuilder.setLength(0);

        		 System.out.println(cal.getTime());

        		 cal.add(Calendar.DATE, 1);

        		 stringBuilder.append(cal.getTime());

                 finalString = stringBuilder.toString();

        		 

        		 SimpleDateFormat parseFormat = 

        				    new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

        				Date date = parseFormat.parse(finalString);

        				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        				appointmentDate = format.format(date);

        		       System.out.println(" appointmentDate : "+appointmentDate);

        		 

        		 

        		 

        		 

        		 

        	 }

        	 

        	 finalString = stringBuilder.toString();

         

         // split time

             String[] allStrings = finalString.split("\\s");

         

         for (int j = 0; j < allStrings.length-3; j++){

             endDateTime = endDateTime + " " + allStrings[j];

             endDateTime=endDateTime.trim();

           

         }

         

         int staffid = 0;

         int vacationStaffid = 0;

         int appointmentStaffid = 0;

         int smartAppointmentstaffid = 0;

         int m=0;

         

         for(i=0;i<=8;i++)

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

        	 

                 staffList = smartAppointmentDAO.getStaffAvailable(serviceType,starttime,endtime,appointmentDate);

                

              

               StringBuilder idList = new StringBuilder();

       		   for (int s = 0; s < staffList.size(); s++) {

       			 staffid=staffList.get(s).staffId;

       			// StaffModel staffModel = new StaffModel();

       			// String servicetype= staffList.get(s).serviceType;

       			// String staffFirstname=staffList.get(s).fName;

       			// String staffLastname=staffList.get(s).lName;

       			// String weekday=staffList.get(s).weekday;

       			/* staffModel.setServiceType(servicetype);

       			 staffModel.setStaffId(staffid);

       			 staffModel.setfName(staffFirstname);

       			 staffModel.setlName(staffLastname);

       			 staffModel.setWeekday(weekday);

       			 staffDetails.add(staffModel);*/

       			 idList.append(staffid+",");

       			

       		 }	 

       		   idList.deleteCharAt(idList.length()-1);

       		   System.out.println(idList);

       		 //  String vacationStartDate = new StringBuilder().append(endDateTime).append(" ").append("2017").toString();

       		List<StaffModel> vactionStaffList = smartAppointmentDAO.getStaffVacation(staffid,appointmentDate,idList);

       		idList.setLength(0);

       		 

        	// ArrayList<Object> vacationStaffDetails = new ArrayList<Object>();

       		for (int s = 0; s < vactionStaffList.size(); s++) {

       			vacationStaffid=vactionStaffList.get(s).staffId;

   			 // Remove vacation staff from availble staff logic

   			

   			 for (int k = 0; k < staffList.size(); k++) {

   				      staffid=staffList.get(k).staffId;

   				           if(staffid == vacationStaffid){

   				            staffList.remove(k);

   			               }

   			     }

   			 

       		}	 

       		 

       		// Update staffIdlist and check appointment slots

       	    for (int s = 0; s < staffList.size(); s++) {

      			 staffid=staffList.get(s).staffId;

      			idList.append(staffid+",");

       	    }

       	     idList.deleteCharAt(idList.length()-1);

 		     System.out.println("After Staff vacation Id List : "+idList);

 		     System.out.println(" Date  : "+ appointmentDate);

 		     System.out.println(" Date  : "+ starttime);

 		    

 		     // Check Appointment slots

 		     List<StaffModel> appointmentsStaffList = smartAppointmentDAO.getAppointmentStafflist(appointmentDate,idList,starttime);

 		     idList.setLength(0);

 		 

        		for (int a= 0; a < appointmentsStaffList.size(); a++) {

        			appointmentStaffid = appointmentsStaffList.get(a).staffId;

    			 // Remove vacation staff from availble staff logic

    			

    			 for (int k = 0; k < staffList.size(); k++) {

    				      staffid=staffList.get(k).staffId;

    				           if(staffid == appointmentStaffid){

    				            staffList.remove(k);

    			               }

    			     }

    			 

        		}	 

        		 

        		// Update staffIdlist and check appointment slots

        	    for (int s = 0; s < staffList.size(); s++) {

       			 staffid=staffList.get(s).staffId;

       			idList.append(staffid+",");

        	    }

        	     idList.deleteCharAt(idList.length()-1);

 		         System.out.println("Update Staff list after appointments slot check : " +idList);

 		     

 		     

 		     

 		     

       		 // Check Distance between Patient to staff

 		     

       		   if(i==0)

       		   {

       		       // *** Logic find out distance between patient and staff address.**** 

       			   // get patent details 

       			  

       			    cisResults = smartAppointmentDAO.getPatientDetails(patientId);

       			    PatientModel patientModel = (PatientModel)cisResults.getResultObject();

       			    float patientLattitue = patientModel.getLattitude();

       			    float patientLongitude = patientModel.getLongitude();

       			    // Get Staff lang lat  result

       			 for (int s = 0; s < staffList.size(); s++) {

       			    StaffModel staffModel = new StaffModel();

       			          staffid=staffList.get(s).staffId;

       				float staffLattitue = staffList.get(s).lattitude;

       				float staffLongitude = staffList.get(s).longitude;

       			     // Get distance between Patinet location to staff Location

       				double earthRadius = 6371; // Radius of the earth

       			    double dLat = Math.toRadians(staffLattitue-patientLattitue);

       			    double dLng = Math.toRadians(staffLongitude-patientLongitude);

       			    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +

       			               Math.cos(Math.toRadians(patientLattitue)) * Math.cos(Math.toRadians(staffLattitue)) *

       			               Math.sin(dLng/2) * Math.sin(dLng/2);

       			    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

       			   // float dist = (float) (earthRadius * c);

       			    double distance = earthRadius * c * 1000; // convert to meters

       			    System.out.println(distance);

       			    staffModel.setStaffId(staffid);

       			    staffModel.setDistance(distance);

       			    appointmentCoordinates.add(staffModel);

       			  } 

       		   }

       			   

       		if(i>0)

    		   {

       			      // Check before slot have appointments or not 

       			

       		    String beforeSlot = hoursList.get(i-1).toString();

       		    System.out.println(" BeforeSlot : " + beforeSlot);	

       			

       			   // Staff have before slot or not, if have slot take patient address

       		    

       		      

       		      //  Staff have no Appointment in before slot take staff address

       		    

       		    cisResults = smartAppointmentDAO.getPatientDetails(patientId);

			    PatientModel patientModel = (PatientModel)cisResults.getResultObject();

			    float patientLattitue = patientModel.getLattitude();

			    float patientLongitude = patientModel.getLongitude();

			    // Get Staff lang lat  result

			    for (int s = 0; s < staffList.size(); s++) {

			    StaffModel staffModel = new StaffModel();

			          staffid=staffList.get(s).staffId;

				float staffLattitue = staffList.get(s).lattitude;

				float staffLongitude = staffList.get(s).longitude;

			   

				// Get distance between Patinet location to staff Location

				double earthRadius = 6371; // Radius of the earth

			    double dLat = Math.toRadians(staffLattitue-patientLattitue);

			    double dLng = Math.toRadians(staffLongitude-patientLongitude);

			    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +

			               Math.cos(Math.toRadians(patientLattitue)) * Math.cos(Math.toRadians(staffLattitue)) *

			               Math.sin(dLng/2) * Math.sin(dLng/2);

			    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

			   // float dist = (float) (earthRadius * c);

			    double distance = earthRadius * c * 1000; // convert to meters

			    System.out.println(distance);

			    staffModel.setStaffId(staffid);

			    staffModel.setDistance(distance);

			    appointmentCoordinates.add(staffModel);

       			

    		   }}

       		

       		   // before placement

       		 

       		 

        }

        	 

        

        	

         

           // End of Hours Loop

         }

          

         

         // To check Minimum meters distance in totla day

			

    		double min =  appointmentCoordinates.get(0).getDistance();

    		for (int l = 0; l< appointmentCoordinates.size(); l++) {

    			double distance = appointmentCoordinates.get(l).getDistance();

    			System.out.println("DISTANCE "+ distance);

    			if(distance < min) 

    				min = distance;

    		}

    		   System.out.println("MIN = " + min);

    		  

    		 for (int l = 0; l< appointmentCoordinates.size(); l++) {

    			double distance = appointmentCoordinates.get(l).getDistance();

    			

    			if(distance == min)

    			  {

    				  

    				  if (m==0)

    				  {    				  

    				smartAppointmentstaffid=appointmentCoordinates.get(l).staffId;

    				   

    				   for (int s = 0; s < staffList.size(); s++) {

    	       			 staffid=staffList.get(s).staffId;

    	       			

    	       			 if(staffid == smartAppointmentstaffid)

    	       			 {

    	       			 StaffModel staffModel = new StaffModel();

    	       			 String servicetype= staffList.get(s).serviceType;

    	       			 String staffFirstname=staffList.get(s).fName;

    	       			 String staffLastname=staffList.get(s).lName;

    	       			 String weekday=staffList.get(s).weekday;

    	       			 staffModel.setServiceType(servicetype);

    	       			 staffModel.setStaffId(staffid);

    	       			 staffModel.setfName(staffFirstname);

    	       			 staffModel.setlName(staffLastname);

    	       			 staffModel.setWeekday(weekday);

    	       		     smartAppointmentList.add(staffModel);

    	       			 }

    	       		 }

    				  }  

    				   m=m+1;

    			  }

    		     }

    	

         

            // End of Days loop

		 }

         

         

     	cisResults.setResultObject(smartAppointmentList);

         return cisResults;

         

         

        

     }

}

