/*===========================
FileName: StaffMasterTab.java
Author:Tushar Mahajan
History:
Date:Jul 17, 2020:created
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
@Table(name = "staff_master")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class StaffMaster implements Serializable {
	
	@Id
	@Getter @Setter											// staff_id firstname lastname dob email phone date_of_joining last_active_date
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id")
	private Integer  staff_id; //20
	
	@Column(name = "first_name",nullable = false)
	@NotNull
	@Getter @Setter
    private String firstname;
	
	@Column(name = "last_name",nullable = true)
	@NotNull
	@Getter @Setter
    private String lastname;	// varchar2	50
	
	@Column(name = "dob",nullable = true)
	@NotNull
	@Getter @Setter
    private Date dob;	
	
	@Column(name = "email",nullable = true)
	@NotNull
	@Getter @Setter
    private String email;  //	varchar2	50
	
	@Column(name = "phone",nullable = true)
	@Getter @Setter
    private String phone;	//varchar2	20
	
	@Column(name = "date_of_joining",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
    private Date date_of_joining;
	
	@Column(name = "last_active_date", insertable=false,nullable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
    private Date last_active_date; //	date	

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

    
	@Override
	public String toString() {
		return "StaffMasterTab [staff_id=" + staff_id + ", firstname=" + firstname + ", lastname=" + lastname + ", dob="
				+ dob + ", email=" + email + ", phone=" + phone + ", date_of_joining=" + date_of_joining
				+ ", last_active_date=" + last_active_date + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}


}
