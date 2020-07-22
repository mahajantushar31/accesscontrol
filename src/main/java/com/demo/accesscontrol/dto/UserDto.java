/*===========================
FileName: StaffMasterDto.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tushar mahajan
 *
 */
public class StaffMasterDto {
	
	/*
	 * @Getter @Setter private Integer staff_id; //20
	 */	
	// firstname lastname dob email phone date_of_joining last_active_date
    private String firstname;

    private String lastname;	// varchar2	50
	
    private Date dob;	
	
    private String email;  //	varchar2	50
	
    private String phone;	//varchar2	20
	
    private Date date_of_joining;
	
    private Date last_active_date; //	date	

	


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getDate_of_joining() {
		return date_of_joining;
	}


	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}


	public Date getLast_active_date() {
		return last_active_date;
	}


	public void setLast_active_date(Date last_active_date) {
		this.last_active_date = last_active_date;
	}
	
	@Override
	public String toString() {
		return "StaffMasterDto [firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + ", email=" + email
				+ ", phone=" + phone + ", date_of_joining=" + date_of_joining + ", last_active_date=" + last_active_date
				+ "]";
	}

	
	
	

}
