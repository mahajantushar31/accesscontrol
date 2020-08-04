/*===========================
FileName: UserToAccessCodeMapDto.java
Author:Tushar Mahajan
History:
Date:Jul 29, 2020:created
============================*/


package com.demo.accesscontrol.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Tushar mahajan
 *
 */

public class UserToAccessCodeMapDto implements Serializable{

    	
    private Long user_id;	
	
    private String access_code;
	
    private Integer isAccessGrant;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getAccess_code() {
		return access_code;
	}

	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}

	public Integer getIsAccessGrant() {
		return isAccessGrant;
	}

	public void setIsAccessGrant(Integer isAccessGrant) {
		this.isAccessGrant = isAccessGrant;
	}

	@Override
	public String toString() {
		return "UserToAccessCodeDto [ user_id=" + user_id
				+ ", access_code=" + access_code + ", isAccessGrant=" + isAccessGrant + "]";
	}

	
    	
}
