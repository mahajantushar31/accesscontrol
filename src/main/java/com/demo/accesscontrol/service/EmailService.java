/*===========================
FileName: EmailService.java
Author:Tushar Mahajan
History:
Date:Jul 19, 2020:created
============================*/

package com.demo.accesscontrol.service;

import java.util.Map;

/**
 * @author Tushar mahajan
 *
 */
public interface EmailService {
	
	 String sendInviteMail(Map<String,String> emailCofigParam) throws Exception;
	 
	 String sendPasswordResetMail(Map<String,String> emailCofigParam) throws Exception;
	 
	 String sendNotificationMail(Map<String,String> emailCofigParam) throws Exception;
	 
	 String sendMailWithAttachment(Map<String,String> emailCofigParam) throws Exception;
}
