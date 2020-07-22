
/*===========================
FileName: ReadConfigPropertyController.java
Author:Tushar Mahajan
History:
Date:Jul 19, 2020:created, Carry data loading from config properties file
============================*/

package com.demo.accesscontrol.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Tushar mahajan
 *
 */

//@ConfigurationProperties("config")
public final class ConfigProperties{
	
	Properties prop = new Properties();
	String propFileName = "config.properties";

	private static String authEmail;
	
	private static String authEmailPass;

	
	private static String emailSubject;			//	=ACCESS CONTROL SUBJ email from peoperteies
	
	private static String emailContent;			//	=AccessControl  email content from peoperteies
	
	private static String emailFrom;				//	=mahajan.tush31test@gmail.com
	
	private static String receivingEmail;			//	default =mahajan.tushar31@gmail.com
	
	// # ----attchement -------------
	private static String attachement;				// =false
	
	private static String mimeMsgContent;
	
	
	
	public void readConfig() {
		InputStream  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		try {
			if (inputStream != null) {
					prop.load(inputStream);
				
					System.out.println(" PROPERTY files "+
							" auth email "+prop.getProperty("config.authEmail")+
							//"--> email :"+new ConfigProperties().getAuthEmail()+
							" auth email pass "+prop.getProperty("config.authEmailPass")+
							" email CONTENT "+prop.getProperty("config.emailContent")+
							" EMAIL FROM "+prop.getProperty("config.emailFrom")+
							" EMAIL SUBJ "+prop.getProperty("config.emailSubject")+
							" RECEVING EMAIL "+prop.getProperty("config.receivingEmail")+
							" mimeMSGContent "+prop.getProperty("MimeMsgContent")
						);
					
					if(null!=prop.getProperty("config.authEmail")) {
						setAuthEmail(prop.getProperty("config.authEmail")) ;
					}
					
					if(null!=prop.getProperty("config.authEmailPass")) {
						setAuthEmailPass(prop.getProperty("config.authEmailPass")) ;
					}
					
					if(null!=prop.getProperty("config.emailSubject")) {
						setEmailSubject(""+prop.getProperty("config.emailSubject"));
					}
					
					if(null!=prop.getProperty("config.emailContent")) {
						setEmailContent(prop.getProperty("config.emailContent"));
					}

					if(null!=prop.getProperty("config.emailFrom")) {
						setEmailFrom(prop.getProperty("config.emailFrom"));
					}

					if(null!=prop.getProperty("config.receivingEmail")) {
						setReceivingEmail(prop.getProperty("config.receivingEmail"));
					}

					// # ------------attchement -------------
					if(null!=prop.getProperty("config.attachement")) {
						setAttachement(prop.getProperty("config.attachement"));
					}

					if(null!=prop.getProperty("config.mimeMsgContent")) {
						setMimeMsgContent(prop.getProperty("config.mimeMsgContent"));
					}

					
					
				} else {
					throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
			// =MIME MSG CONETENT email	from peoperteies		

	
	public String getEmailSubject() {
		return emailSubject;
	}
	public String setEmailSubject(String emailSubject) {
		return this.emailSubject=emailSubject;
	}
	
	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getReceivingEmail() {
		return receivingEmail;
	}

	public void setReceivingEmail(String receivingEmail) {
		this.receivingEmail = receivingEmail;
	}

	public String getAttachement() {
		return attachement;
	}

	public void setAttachement(String attachement) {
		this.attachement = attachement;
	}

	public String getMimeMsgContent() {
		return mimeMsgContent;
	}

	public void setMimeMsgContent(String mimeMsgContent) {
		this.mimeMsgContent = mimeMsgContent;
	}

	public String getAuthEmail() {
		return authEmail;
	}

	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}

	public String getAuthEmailPass() {
		return authEmailPass;
	}

	public void setAuthEmailPass(String authEmailPass) {
		this.authEmailPass = authEmailPass;
	}

	
	
	@Override
	public String toString() {
		return "ConfigProperties [authEmail=" + authEmail + ", authEmailPass=" + authEmailPass + ", emailSubject="
				+ emailSubject + ", emailContent=" + emailContent + ", emailFrom=" + emailFrom + ", receivingEmail="
				+ receivingEmail + ", attachement=" + attachement + ", mimeMsgContent=" + mimeMsgContent + "]";
	}
	
	

	
	
	
	
	
}
