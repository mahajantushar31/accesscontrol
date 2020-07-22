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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
// @Table(name = "staff_master")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class User implements Serializable {
	
// old: // staff_id firstname lastname dob email phone date_of_joining last_active_date
	
// new:	email	Role-_id Password	firstname	lastname	dob	phone	date_of_joining	last_active_date	

	
	@Id
	@Getter @Setter											
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=20)
	private long  user_id; 
	// @OneToOne(optional=false)  @JoinColumn(  name="", unique=true, nullable=false, updatable=false)
	@Column(nullable = false,length=50,unique=true)@NotNull
    private String email;  
	
	@Column(length = 15,nullable = true)
	@NotNull
    private String role_id;
	
	@Column(length = 25,nullable = false)
	@NotNull
    private String password;
	
	@Column(length = 25,nullable = false)
	@NotNull
    private String firstname;
	
	@Column(length = 25,nullable = true)
	@NotNull
    private String lastname;	// varchar2	50
	
	@Column(insertable=false,nullable = true, updatable = false)
	@NotNull
	//@Temporal(TemporalType.TIMESTAMP)
    private Date dob;
	
	@Column(length = 20,nullable = true)
    private String phone;	//varchar2	20
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
    private Date date_of_joining;
	
	@Column(insertable=false,nullable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date last_active_date; //	date	


	// ----- For Record ---------
	/*
	 * @Column(nullable = false, updatable = false)
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @CreatedDate private Date createdAt;
	 * 
	 * 
	 * 
	 * @Column(nullable = false)
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @LastModifiedDate private Date updatedAt;
	 */
	// CTOR
	public User(){}
	
	public User(String roleId){
		this.role_id=roleId;
	}
	
	
	

	// --------------GETTERS SETTERS -----------------

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	/*
	 * public Date getCreatedAt() { return createdAt; }
	 * 
	 * public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	 * 
	 * 
	 * public Date getUpdatedAt() { return updatedAt; }
	 * 
	 * 
	 * public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
	 */


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", role_id=" + role_id + ", password="
				+ password + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + ", phone=" + phone
				+ ", date_of_joining=" + date_of_joining + ", last_active_date=" + last_active_date + ""
						+ //", createdAt="+ createdAt + ", updatedAt=" + updatedAt +
						"]";
	}


}
