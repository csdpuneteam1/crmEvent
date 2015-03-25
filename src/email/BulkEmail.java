package email;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import model.Customer;

public class BulkEmail {

	private String smtpHost;
	private String smtpPort;
	private String senderEmail;
	private String senderUsername;
	private String senderPassword;
	
	public void loadProperties() {
		//Reading properties file in Java example
        Properties props = new Properties();
        FileInputStream fis;
		try {
			fis = new FileInputStream("bin/resources/smtp.properties");
		      
	        //loading properites from properties file
	        props.load(fis);
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
 

        //reading proeprty
        smtpHost = props.getProperty("smtp.host");
        smtpPort = props.getProperty("smtp.port");
        senderEmail = props.getProperty("smtp.senderEmail");
        senderUsername = props.getProperty("smtp.serderUsername");
        senderPassword = props.getProperty("smtp.serderPassword");
	}
	
	public boolean sendEmail(Customer customer, String subject, String pdfFileName ) {
	   boolean sentSuccessfully = true;
	   
      // Recipient's email ID needs to be mentioned.
      String toAddress = customer.getEmailAddress();
      String messageBody = "Dear " + customer.getCustomerName() + " mesage from CRM";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", smtpHost);
      props.put("mail.smtp.port", smtpPort);

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(senderUsername, senderPassword);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(senderEmail));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(toAddress));

         // Set Subject: header field
         message.setSubject(subject);

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText(messageBody);

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         DataSource source = new FileDataSource(pdfFileName);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(pdfFileName);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
         
  
      } catch (MessagingException e) {
    	  sentSuccessfully  = false;
    	  throw new RuntimeException(e);
      }
      return sentSuccessfully;
   }
}