/*===========================
FileName: VisitorScanTab.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.entity;

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
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class AccessPoint implements Serializable{
							// accessPoint_id  accessPoint_name  accessPoint_code  isEnable
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessPoint_id;
    	
	@Column(length=50 ,nullable = false, updatable = false)
    private String accessPoint_name;	
	
	@Column(length=50 ,nullable = false, updatable = false, unique= true)
    private String accessPoint_code;	
	
	@Column(nullable = false, updatable = false)
    private Integer isAvailable=1;							// 1 : enable, 0 : disable
		
	@Column(nullable = false, updatable = false)
    @CreatedDate
	private Date createdAt;

	// ------ GETTES SETTERS ------------------
	
	public Long getAccessPoint_id() {
		return accessPoint_id;
	}

	public void setAccessPoint_id(Long accessPoint_id) {
		this.accessPoint_id = accessPoint_id;
	}

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "AccessPoint [accessPoint_id=" + accessPoint_id + ", accessPoint_name=" + accessPoint_name
				+ ", accessPoint_code=" + accessPoint_code + ", isAvailable=" + isAvailable + ", creatd=" + createdAt + "]";
	}

	//----- GETTERS SETTERS -------------------

	
	
	
	
}
