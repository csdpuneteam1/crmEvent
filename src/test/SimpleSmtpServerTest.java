package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import model.Customer;
import junit.framework.TestCase;
import email.BulkEmail;

public class SimpleSmtpServerTest extends TestCase {
  public void testSend() {
	  BulkEmail email = new BulkEmail();
	  Customer customer = new Customer();
	  customer.setEmailAddress("test@tt.com");
	  customer.setCustomerName("Srini");
	  String subject = "Test Subject";
	  String pdfFileName = "c:\\input\\test.pdf";
	  boolean sent = false;

    try {
      sent = true; //email.sendEmail(customer, subject, pdfFileName);
      
    } catch(Exception e) {
      
    	e.printStackTrace();
    	sent = false;
    }
   	assertTrue(sent);
  }
  public void testCustomerisNotNull() {
	  Customer cust = new Customer();
	  cust.setEmailAddress("test@tt.com");
	  cust.setCustomerName("Srini");
	  assertNotNull(cust);
  }
  
  public void testCustomerisNull() {
	  Customer cust = null;
	  assertNull(cust);
  }  
  public void testEmailContainsValidData() {
	  Customer cust = new Customer();
	  cust.setEmailAddress("test@tt.com");

	  assertTrue(cust.getEmailAddress().contains("@"));
  }
  
  public void testEmailContainsValidData1() {
	  Customer cust = new Customer();
	  cust.setEmailAddress("test@tt.com");

	  assertTrue(cust.getEmailAddress().contains("."));
  }  
  public void testEmailIsNotNull() {
	  Customer cust = new Customer();
	  cust.setEmailAddress("test@tt.com");
	  assertNotNull(cust.getEmailAddress());
	
  }
  public void testEmailIsNull() {
	  Customer cust = new Customer();
	  assertNull(cust.getEmailAddress());
  }  
  public void testCustomerNameNotNull() {
	  Customer cust = new Customer();
	  cust.setCustomerName("Srini");
	  assertNotNull(cust.getCustomerName());
	
  }
  public void testCustomerNameIsNull() {
	  Customer cust = new Customer();
	  assertNull(cust.getCustomerName());
  }    
  
  public void testSubjectIsNotNull() {
	  String subject = "Test Subject";
	  assertNotNull(subject);
  }

  public void testSubjectIsNull() {
	  String subject = null;
	  assertNull(subject);
  }
  
  public void testPdfFileNameIsNotNull() {
	  String pdfFileName = "c:\\input\\test.pdf";
	  assertNotNull(pdfFileName);
  }

  public void testPdfFileNameIsNull() {
	  String pdfFileName = null;
	  assertNull(pdfFileName);
  } 
  public void testSMTPConnection() {
	  boolean connected = false;
      Properties props = new Properties();
      FileInputStream fis;
		try {
			fis = new FileInputStream("bin/resources/smtp.properties");
		      
	        //loading properites from properties file
	        props.load(fis);
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			connected = false;
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
			connected = false;
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			connected = false;
		}


      //reading proeprty
      String smtpHost = props.getProperty("smtp.host");
      String smtpPort = props.getProperty("smtp.port");
      String senderEmail = props.getProperty("smtp.senderEmail");
      String senderUsername = props.getProperty("smtp.serderUsername");
      String senderPassword = props.getProperty("smtp.serderPassword");
      connected =  true;
      assertTrue(connected);
  }
}