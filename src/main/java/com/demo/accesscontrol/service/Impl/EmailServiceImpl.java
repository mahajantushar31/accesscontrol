/*===========================
FileName: EmailServiceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 19, 2020:created
============================*/

package com.demo.accesscontrol.service.Impl;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.demo.accesscontrol.common.util.EmailUtil;
import com.demo.accesscontrol.service.EmailService;

/**
 * @author Tushar mahajan
 *
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService{

	@Override
	public String sendInviteMail(){
		// 
		try {
			EmailUtil.sendmail();
			return "Email Send Suuscefully ";
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error while sending mail";
	}

	@Override
	public String sendPasswordResetMail() throws Exception {
		// FORGOT Password
		return null;
	}

	@Override
	public String sendNotificationMail() throws Exception {
		// 
		return null;
	}

	@Override
	public String sendMailWithAttachment() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
