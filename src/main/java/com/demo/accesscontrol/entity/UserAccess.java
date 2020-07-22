/*===========================
FileName: AccessTab.java
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
@Table(name = "access_master")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class AccessMaster implements Serializable{

	@Id
	@Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id")
	private Integer  staff_id;	//	number	20
	
	@Column(name = "password",nullable = false)
	@NotNull
    private String password;	//	varchar2	30
	
	@Column(name = "role_id",nullable = false)
	@NotNull
    private String role_id;		//	number	20
	
	@Column(name = "access_creation_date",nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
    private Date accessCreationDate;	//	date	
	
	@Column(name = "access_valid_date",nullable = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
    private Date accessValidDate;	//	date	
	

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
    

	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
    
    
    
    // ----------------- GETTER /SETTER ENDS -------------------- 
	@Override
	public String toString() {
		return "AccessTab [staff_id=" + staff_id + ", password=" + password + ", role_id=" + role_id
				+ ", accessCreationDate=" + accessCreationDate + ", accessValidDate=" + accessValidDate + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

    
}
