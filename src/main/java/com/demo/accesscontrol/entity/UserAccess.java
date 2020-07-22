/*===========================
FileName: AccessTab.java

Author:Tushar Mahajan
History:
Date:Jul 17, 2020:created
	:Jul 20, 2020:1:table structure updated acce_name=email,accessCode="ACC1",QR_code=""	
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Tushar mahajan
 *
 */
@Entity
// @Table(name = "access_master")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class UserAccess implements Serializable{
// old 
// 	staff_id,  password, role_id, access_creation_date, access_valid_date
	
//  new unsestanding	
// 	User,    QR(AccCode),role_id, access_creation_date,access_valid_date	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  access_id;	

	@Column(length=45,nullable = false,unique=true)
	private String  access_name;	
	
	@Column(length=25,nullable = false)
	private String  access_code;
	
	@Column(length=20,nullable = false)
	@NotNull
    private String role_id;		
	
	/*
	 * @Column(length=20,nullable = false)
	 * 
	 * @NotNull private String qr_code;
	 */
	
	@Column(nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
    private Date accessCreationDate;	
	
	@Column(name = "access_valid_date",nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
    private Date accessValidDate;		
	

	// ----- For Record ---------
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    

    //-----------------GETTERS / SETTER STARTS -------------------
    
    public Integer getAccess_id() {
		return access_id;
	}

	public void setAccess_id(Integer access_id) {
		this.access_id = access_id;
	}

	public String getAccess_name() {
		return access_name;
	}

	public void setAccess_name(String access_name) {
		this.access_name = access_name;
	}

	public String getAccess_code() {
		return access_code;
	}

	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}

	public String getRole_id() {
		return role_id;
	}


	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}


	public Date getAccessCreationDate() {
		return accessCreationDate;
	}

	public void setAccessCreationDate(Date accessCreationDate) {
		this.accessCreationDate = accessCreationDate;
	}

	public Date getAccessValidDate() {
		return accessValidDate;
	}

	public void setAccessValidDate(Date accessValidDate) {
		this.accessValidDate = accessValidDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "AccessMaster [access_id=" + access_id + ", access_name=" + access_name + ", access_code=" + access_code
				+ ", role_id=" + role_id + /* ", qr_code=" + qr_code + */  ", accessCreationDate="+ accessCreationDate
				+ ", accessValidDate=" + accessValidDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}


}
