package com.digitalhealthcare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.TimeCheck;
import com.cis.testServiceTime;

public class SmartAppointmentDAO extends JdbcDaoSupport {

	public CISResults smartAppointmentService(String serviceType,
			String patientId, String aptWith, String staffId, String startDateTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public CISResults getPatientDetails(String patientId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{patientId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 PatientModel res=(PatientModel)getJdbcTemplate().queryForObject(SmartAppointmentQuery.SQL_GETPATIENTEMAIL,inputs,new PatientMapper());
		     cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("patient email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	public CISResults getStaffDetails(int staffId) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		StaffModel getstaffEmail=new StaffModel();
		Object[] inputs = new Object[]{staffId};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 StaffModel res=(StaffModel)getJdbcTemplate().queryForObject(SmartAppointmentQuery.SQL_GETSTAFFEMAIL,inputs,new StaffMapper());
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	public List<StaffModel> getStaffAvailable(String serviceType, String startHour, String endHour, String startDateTime) {
		// TODO Auto-generated method stub

		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		List<StaffModel> getstaffList=null;
		Object[] inputs = new Object[]{serviceType,startHour,endHour,startDateTime};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 getstaffList= getJdbcTemplate().query(SmartAppointmentQuery.SQL_GETSTAFFSERVICETYPE,inputs,new StaffServiceTypeMapper());
			 //cisResults.setResultObject(getstaffList);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return getstaffList; 
	}

	public List<StaffModel> getStaffVacation(int staffid, String vacationStartDate,StringBuilder idList) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		List<StaffModel> getstaffVacationList=null;
		Object[] inputs = new Object[]{vacationStartDate,vacationStartDate};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			// Hard coded, will change later
			 String Query = "select * from Staff_vacation where STR_TO_DATE(?,'%Y-%m-%d')>= DATE(str_to_date(Start_datetime,'%a %b %d %Y %T')) and STR_TO_DATE(?,'%Y-%m-%d')<= DATE(str_to_date(end_datetime,'%a %b %d %Y %T'))and Staff_id in"+"("+idList+")";
			 getstaffVacationList = getJdbcTemplate().query(Query,inputs,new StaffVacationMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return getstaffVacationList; 
	}

	public CISResults getStaffAppt(int stafId, String startDateTime) {
		// TODO Auto-generated method stub
        CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		Object[] inputs = new Object[]{stafId,startDateTime};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 StaffModel res=(StaffModel)getJdbcTemplate().queryForObject(SmartAppointmentQuery.SQL_GETSTAFFAPPOINTMENT,inputs,new StaffVacationMapper());
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			//cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	public CISResults getPatientAvailable(String patientId, String aptTime) {
		// TODO Auto-generated method stub


		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		
		Object[] inputs = new Object[]{patientId,aptTime};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 PatientModel res=(PatientModel)getJdbcTemplate().queryForObject(SmartAppointmentQuery.SQL_GETPATIENTAPPOINTMENT,inputs,new PatientAppointmentMapper());
			 cisResults.setResultObject(res);
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			//cisResults.setErrorMessage("Failed to get  Data");
		}
   		return cisResults; 
	}

	public List<StaffModel> getAppointmentStafflist(
			String startDateTime, StringBuilder idList,String starttime) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		List<StaffModel> getstaffAppointments=null;
		Object[] inputs = new Object[]{startDateTime,starttime};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			 // Hard coded, will change later
			 String Query = "select * from Appointments_table where Apt_person_id in "+"("+idList+")and DATE(str_to_date(Apt_starttime,'%a %b %d %Y %T')) = STR_TO_DATE(?,'%Y-%m-%d')and TIME(str_to_date(Apt_starttime,'%a %b %d %Y %T')) = ?";
			 getstaffAppointments = getJdbcTemplate().query(Query,inputs,new StaffAppointmentMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return getstaffAppointments; 
	}

	public List<StaffModel> getPriorSlotDetails(String beforeSlot,
			String appointmentDate, StringBuilder idList) {
		// TODO Auto-generated method stub
		CISResults cisResults=new CISResults();
		cisResults.setResponseCode(CISConstants.RESPONSE_SUCCESS);
		List<StaffModel> getDistanationsList=null;
		Object[] inputs = new Object[]{appointmentDate,beforeSlot};
		try{
			// Capture service Start time
			 TimeCheck time=new TimeCheck();
			 testServiceTime sessionTimeCheck=new testServiceTime();
			 String serviceStartTime=time.getTimeZone();
			// Hard coded, will change later
			 String Query = " select st.staff_id,ifnull(stap.Lattitude,st.Lattitude) as latitude,ifnull(stap.longitude,st.longitude) as longitude from Staff_table st left outer join(SELECT ap.Apt_person_id,ap.apt_id,ap.patient_id,pt.Lattitude,pt.Longitude from Appointments_table ap , Profile_table pt where ap.patient_id = pt.user_id and DATE( str_to_date( ap.Apt_starttime, '%a %b %d %Y %T' ) ) = STR_TO_DATE(?, '%Y-%m-%d' )and TIME( str_to_date( ap.Apt_starttime, '%a %b %d %Y %T' ) ) = ? )stap on st.staff_id=stap.Apt_person_id where st.staff_id in "+"("+idList+")";
			 
			 
			 
			 getDistanationsList = getJdbcTemplate().query(Query,inputs,new StaffDistancesMapper());
			 String serviceEndTime=time.getTimeZone();
			 long result=sessionTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			 logger.info("staff email query time:: " +result);
		} catch (DataAccessException e) {
			e.printStackTrace();
			cisResults.setResponseCode(CISConstants.RESPONSE_FAILURE);
			cisResults.setErrorMessage("Failed to get  Data");
		}
   		return getDistanationsList; 
	}

}