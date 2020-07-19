/*===========================
FileName: StaffMasterDto.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

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
	
	@Getter @Setter
    private String firstname;

	@Getter @Setter
    private String lastname;	// varchar2	50
	
	@Getter @Setter
    private Date dob;	
	
	@Getter @Setter
    private String email;  //	varchar2	50
	
	@Getter @Setter
    private String phone;	//varchar2	20
	
	@Getter @Setter
    private Date date_of_joining;
	
	@Getter @Setter
    private Date last_active_date; //	date	

	
	@Override
	public String toString() {
		return "StaffMasterDto [firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + ", email=" + email
				+ ", phone=" + phone + ", date_of_joining=" + date_of_joining + ", last_active_date=" + last_active_date
				+ ", createdAt=" + "]";
	}
	

}
