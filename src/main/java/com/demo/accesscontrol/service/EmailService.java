/*===========================
FileName: EmailService.java
Author:Tushar Mahajan
History:
Date:Jul 19, 2020:created
============================*/

package com.demo.accesscontrol.service;

/**
 * @author Tushar mahajan
 *
 */
public interface EmailService {
	
	 String sendInviteMail() throws Exception;
	 
	 String sendPasswordResetMail() throws Exception;
	 
	 String sendNotificationMail() throws Exception;
	 
	 String sendMailWithAttachment() throws Exception;
}
