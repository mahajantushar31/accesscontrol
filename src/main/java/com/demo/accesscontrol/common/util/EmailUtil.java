
/*===========================
FileName: EmailUtil.java
Author:Tushar Mahajan
History:
Date:Jul 19, 2020:created , Read properties from config.properties files
============================*/

package com.demo.accesscontrol.common.util;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tushar mahajan
 *
 */
public class EmailUtil {
	
	private static final Logger logger=LoggerFactory.getLogger(EmailUtil.class); 
	
	
	public static void sendmail(Map<String,String> emailCofigParam) throws AddressException, MessagingException, IOException {
			System.out.println(" email Config "+emailCofigParam);
			// ConfigProperties config=new ConfigProperties();
			
			String emailSubject=emailCofigParam.get(AccessCtrlConstant.EMAIL_SUBJECT);				//config.getEmailSubject();  			//"ACCESS CONTROL SUBJ email";		
			String emailContent=emailCofigParam.get(AccessCtrlConstant.EMAIL_CONTENT);					//config.getEmailContent(); 			//"AccessControl  email content";
			String emailFrom=emailCofigParam.get(AccessCtrlConstant.EMAIL_FROM);						//config.getEmailFrom(); 				// "tushar.mahajan@beutosys.com";
			String authEmail=emailCofigParam.get(AccessCtrlConstant.AUTH_EMAIL);						//config.getAuthEmail();        			 
			String authEmailPass=emailCofigParam.get(AccessCtrlConstant.AUTH_MAIL_PASS);					//config.getAuthEmailPass();			
			String receivingEmail=emailCofigParam.get(AccessCtrlConstant.RECEIVE_EMAIL);					//config.getReceivingEmail();				
			String mimeMsgContent=emailCofigParam.get(AccessCtrlConstant.MIME_MSG_CONTENT);					//config.getMimeMsgContent();		//		"MIME MSG CONETENT email";		
			
			String str=emailCofigParam.get(AccessCtrlConstant.ATTACHEMENT);															//config.getAttachement();
			str=(null!=str && !str.trim().isEmpty())?"false":str;
			boolean attachement= Boolean.parseBoolean(str);					//				false;
			 String attachFilePath=null;									// "/var/tmp/image19.png";
			
			Properties props = new Properties();
						   props.put("mail.smtp.auth", "true");
						   props.put("mail.smtp.starttls.enable", "true");
						   props.put("mail.smtp.host", "smtp.gmail.com");
						   props.put("mail.smtp.port", "587");
						   
						   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
						      protected PasswordAuthentication getPasswordAuthentication() {
						         return new PasswordAuthentication(authEmail,authEmailPass);				// email pass Auth
						      }
						   });
						   Message msg = new MimeMessage(session);
						   msg.setFrom(new InternetAddress(emailFrom, false));									// from Email
				
						   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receivingEmail));	// receiver mail
						   msg.setSubject(emailSubject);														// email subj
						   msg.setContent(emailContent, "text/html");											// email Content
						   msg.setSentDate(new Date());
				
						   MimeBodyPart messageBodyPart = new MimeBodyPart();
						   messageBodyPart.setContent(mimeMsgContent, "text/html");								// Mime msg bodyContent
				
						 
						  //  --- email with aatchement ----- 
						   if(true==attachement) {
							   Multipart multipart = new MimeMultipart();
							   multipart.addBodyPart(messageBodyPart);
							   MimeBodyPart attachPart = new MimeBodyPart();
							   attachPart.attachFile(attachFilePath);												//  attachement path
							   multipart.addBodyPart(attachPart);
							   msg.setContent(multipart);
						   }
						   Transport.send(msg);
				
		}
	
	
}
