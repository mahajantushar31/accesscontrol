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
    private Integer sno;
    	
	@Column(length=50 ,nullable = false, updatable = false)
    private String lastname;	
	
	@Column(length=50 ,nullable = false, updatable = false)
    private String firstname;
	
	@Column(length=50 ,nullable = false, updatable = false)
    private String email;
	
	@Column(length=4,nullable = false, updatable = false)
    private Integer age;
	
	@Column(length=20 ,nullable = false, updatable = false)
    private String phone;
	
	@Column(nullable = false,insertable=false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_of_visit;	
	
	@Column(nullable = false, updatable = false)
    private String purpose_of_visit;	
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date scan_date;
	
	@Column(nullable = false, updatable = false)
    private double scan_temp;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date scan_type;
	// ------ GETTES SETTERS ------------------
	
    public Integer getSno() {
			return sno;
		}

		public void setSno(Integer sno) {
			this.sno = sno;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Date getDate_of_visit() {
			return date_of_visit;
		}

		public void setDate_of_visit(Date date_of_visit) {
			this.date_of_visit = date_of_visit;
		}

		public String getPurpose_of_visit() {
			return purpose_of_visit;
		}

		public void setPurpose_of_visit(String purpose_of_visit) {
			this.purpose_of_visit = purpose_of_visit;
		}

		public Date getScan_date() {
			return scan_date;
		}

		public void setScan_date(Date scan_date) {
			this.scan_date = scan_date;
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
	
	
	//----- GETTERS SETTERS -------------------

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
				return "VisitorScan [sno=" + sno + ", lastname=" + lastname + ", firstname=" + firstname + ", email="
						+ email + ", age=" + age + ", phone=" + phone + ", date_of_visit=" + date_of_visit
						+ ", purpose_of_visit=" + purpose_of_visit + ", scan_date=" + scan_date + ", scan_temp="
						+ scan_temp + ", scan_type=" + scan_type + ", createdAt=" + createdAt + ", updatedAt="
						+ updatedAt + "]";
			}
	
	
	
}
