/*===========================
FileName: UserLoginDto.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.dto;

import java.io.Serializable;
import java.util.Date;

import com.demo.accesscontrol.common.util.DateUtil;

/**
 * @author Tushar mahajan
 *
 */
public class UserLoginDto implements Serializable {
	
	/*
	 * @Getter @Setter private Integer staff_id; //20
	 */	
	// firstname lastname dob email phone date_of_joining last_active_date
    private String username;

   // private String email; 
    private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginDto [username=" + username + ", password=" + password + "]";
	}
		

	
	

	
	
	

}
