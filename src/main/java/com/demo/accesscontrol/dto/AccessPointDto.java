/*===========================
FileName: AccessPointDto.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tushar mahajan
 *
 */

public class AccessPointDto {
							// accessPoint_id  accessPoint_name  accessPoint_code  isEnable

    	
    private String accessPoint_name;	
	
    private String accessPoint_code;	
	
    private Integer isAvailable;   // 1 availabel  0: unavailable
		
	// ------ GETTES SETTERS ------------------
	

	public String getAccessPoint_name() {
		return accessPoint_name;
	}

	public void setAccessPoint_name(String accessPoint_name) {
		this.accessPoint_name = accessPoint_name;
	}

	public String getAccessPoint_code() {
		return accessPoint_code;
	}

	public void setAccessPoint_code(String accessPoint_code) {
		this.accessPoint_code = accessPoint_code;
	}

	public Integer getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Integer isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "AccessPoint [ accessPoint_name=" + accessPoint_name
				+ ", accessPoint_code=" + accessPoint_code + ", isAvailable=" + isAvailable + "]";
	}
	
	
	//----- GETTERS SETTERS -------------------

	
	
	
	
}
