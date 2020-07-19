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
@Table(name = "visitor_scan")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class VisitorScan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter
    private Integer sno;
    	
	@Column(name="last_name" ,nullable = false, updatable = false)
    @Getter @Setter
    private String lastname;	
	
	@Column(name="first_name" ,nullable = false, updatable = false)
    @Getter @Setter
    private String firstname;
	
	@Column(name="email" ,nullable = false, updatable = false)
    @Getter @Setter
    private String email;
	
	@Column(name="age" ,nullable = false, updatable = false)
    @Getter @Setter
    private Integer age;
	
	@Column(name="phone" ,nullable = false, updatable = false)
    @Getter @Setter
    private String phone;
	
	@Column(name="date_of_visit",nullable = false,insertable=false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date date_of_visit;	
	
	@Column(name="purpose_of_visit",nullable = false, updatable = false)
    @Getter @Setter
    private String purpose_of_visit;	
	
	@Column(name="date_of_visit",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date scan_date;
	
	@Column(name="scan_temp",nullable = false, updatable = false)
    @Getter @Setter
    private double scan_temp;
	
	@Column(name="scan_type",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date scan_type;
	

	// ----- For Record ---------
			@Column(nullable = false, updatable = false)
		    @Temporal(TemporalType.TIMESTAMP)
		    @Getter @Setter
		    @CreatedDate
		    private Date createdAt;

		    @Column(nullable = false)
		    @Temporal(TemporalType.TIMESTAMP)
		    @LastModifiedDate
		    @Getter @Setter
		    private Date updatedAt;
	
	
	
}
