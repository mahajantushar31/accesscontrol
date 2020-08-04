/*===========================
FileName: AccessLog.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.entity;

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
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class AccessLog {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long log_id;
    	
	@Column(nullable = false, updatable = false)
    private Integer access_id;	
	
	@Column(length=50 ,nullable = false, updatable = false)
    private Integer temp;
	
	@Column(length=50 ,nullable = false, updatable = false)
    private String inDateTime;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date outDateTime;
	
	@Column(nullable = false, updatable = false)
    private double scan_temp;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date scan_type;
	
	
	
	
	// ------ GETTES SETTERS ------------------
	public Long getLog_id() {
		return log_id;
	}

	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}

	public long getAccess_id() {
		return access_id;
	}

	public void setAccess_id(Integer access_id) {
		this.access_id = access_id;
	}

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	public String getInDateTime() {
		return inDateTime;
	}

	public void setInDateTime(String inDateTime) {
		this.inDateTime = inDateTime;
	}

	public Date getOutDateTime() {
		return outDateTime;
	}

	public void setOutDateTime(Date outDateTime) {
		this.outDateTime = outDateTime;
	}

	public double getScan_temp() {
		return scan_temp;
	}

	public void setScan_temp(double scan_temp) {
		this.scan_temp = scan_temp;
	}

	public Date getScan_type() {
		return scan_type;
	}

	public void setScan_type(Date scan_type) {
		this.scan_type = scan_type;
	}

	
	@Override
	public String toString() {
		return "AccessLog [log_id=" + log_id + ", user_id=" + access_id + ", temp=" + temp + ", inDateTime=" + inDateTime
				+ ", outDateTime=" + outDateTime + ", scan_temp=" + scan_temp + ", scan_type=" + scan_type
			+ "]";
	}

	//----- GETTERS SETTERS -------------------

	
	
	
	
}
