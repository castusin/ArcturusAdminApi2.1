package com.cis;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;



public class EmailCommunication {
	
	public String sendMailWithAuth(String host, String user, String password,
	        String port, String to, String body, String subject,String cc, String bcc) throws Exception{
	   
	    
	    Properties props = System.getProperties();

	      props.put("mail.smtp.user", user);
	      props.put("mail.smtp.password", password);
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", port);
	      props.put("mail.debug", "true");
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "false");
	      props.put("mail.smtp.EnableSSL.enable", "false");

	      Session session = Session.getInstance(props, null);
	      session.setDebug(true);

	      MimeMessage message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(user));

	      // To get the array of addresses    
	     message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	     message.addRecipient(RecipientType.CC, new InternetAddress(cc));
	     message.addRecipient(RecipientType.BCC, new InternetAddress(bcc));
	    // message.addRecipient(RecipientType.BCC, new InternetAddress(director));
	    

	      message.setSubject(subject);
	    
	      message.setContent(body, "text/html");
	     
	  
	      Transport transport = session.getTransport("smtp");
	      try {
	          transport.connect(host, user, password);
	          transport.sendMessage(message, message.getAllRecipients());
	          Transport.send(message);
	          transport.close();
	         
	        
	      } finally {
	         
	      }
	      return "0";
	    
	    
	}
	
	public CISResults sendReferFriendMail(String patientEmail, String message,String cc,
			String bcc) {

		String emailId=CISConstants.ADMINEMAILID;
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Dear Arcturus Care Team, </b><br />"+
                 
           
				"<p>"+message+" </b><br />"+
  				
				
                
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.REFERSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	
	public CISResults sendIncidentReportMail(String firstName, String lastName,
			String patientFname, String patientLname, String directorEmail,
			String message, String cc, String bcc) {


		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<p>Dear Arcturus Care Team, </b><br />"+
              /*  "<p>Incident Report - Missed Appointment</b><br />"+*/
               
               /* "<p>Staff Name : " +" "+ firstName +" " + lastName +"  <br />"+*/
               
				 "<p>"+message+" </b>"+
				 "<p>Reported by : "+" " + patientFname +" " + patientLname +"  <br />"+
  				 
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
		String subject = CISConstants.INCIDENTMISSEDSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,directorEmail, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendIncidentReportComplaintMail(String firstName,
			String lastName, String patientFname, String patientLname,
			String directorEmail, String message, String cc, String bcc) {


		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<p>Dear Arcturus Care Team, </b><br />"+
               /* "<p>Incident Report - Compliant</b><br />"+*/
               
               /* "<p>Staff Name :" +" "+ firstName +" " + lastName +" <br />"+*/
               
				"<p>"+message+" </b>"+
				 "<p>Reported by :"+" " + patientFname +" " + patientLname +"  <br />"+
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
		String subject = CISConstants.INCIDENTCOMPLAINTSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,directorEmail, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}


	public CISResults sendIncidentReportSuppliesMail(String firstName,
			String lastName, String patientFname, String patientLname,
			String directorEmail, String message, String cc, String bcc) {


		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<p>Dear Arcturus Care Team, </b><br />"+
               /* "<p>Request for Supplies</b><br />"+*/
               
               
				 "<p> "+message+" </b>"+
				 "<p>Reported by : "+" " + patientFname +" " + patientLname +"  <br />"+
  				 
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
		String subject = CISConstants.INCIDENTSUPPLIESSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,directorEmail, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendReferFriendMail(String patientFirstName,
			String patientLastName, String patientEmail, String friendEmail,
			String friendPhone, String friendName, String message, String cc,
			String bcc) {


		//String emailId=CISConstants.ADMINEMAILID;
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Dear Friend  "+friendName+" </b><br />"+
                 
				"<p>Reference from "+patientFirstName+" "+patientLastName+"  </b><br />"+
				
				"<p>Name :"+friendName+"</b><br />"+
				"<p>Email id : "+friendEmail+" </b><br />"+
				"<p>Phone number :"+friendPhone+" </b><br />"+
				"<p>Message : "+message+" </b><br />"+
  				
				
                
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.REFERSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,friendEmail, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}


	public CISResults sendAdminreplyMail(String emailId, String message,
			String cc, String bcc) {
		// TODO Auto-generated method stub


		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Dear Arcturus Care Team, </b><br />"+
                 
				
				"<p>Message : "+message+" </b><br />"+
  				
				
                
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.SUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}

	public CISResults sendReferFriendMailAdmin(String patientFirstName,
			String patientLastName, String patientEmail, String friendEmail,
			String friendPhone, String friendName, String message, String cc,
			String bcc) {


		String emailId=CISConstants.ADMINEMAILID;
		CISResults cisResult = new CISResults();
		
		String msg="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "<title></title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                 "<p>Dear Arcturus team </b><br />"+
                 
				"<p>Reference from "+patientFirstName+" "+patientLastName+" to  "+friendName+" </b><br />"+
				
				"<p>Name :"+friendName+"</b><br />"+
				"<p>Email id : "+friendEmail+" </b><br />"+
				"<p>Phone number :"+friendPhone+" </b><br />"+
				"<p>Message : "+message+" </b><br />"+
  				
				
                
                
                "<br />\n"+
                "  Thanks,<br />\n" +
                "<br />\n"+
                " Arcturus Team<br />\n" +

                "  <br />\n" +

                "</body>\n" +
                "</html>";
	String subject = CISConstants.REFERSUBJECT;
	 try {
		 String result = sendMailWithAuth(CISConstants.PRODEMAILHOST,CISConstants.PRODEMAILUSERNAME,CISConstants.EMAILPASSWORD,CISConstants.PORT,emailId, msg, subject,cc,bcc);
	  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return cisResult;
	}





}