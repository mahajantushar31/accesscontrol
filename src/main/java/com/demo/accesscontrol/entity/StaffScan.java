/*===========================
FileName: StaffScanTab.java
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
@SuppressWarnings("serial")
@Entity
@Table(name = "staff_scan")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class StaffScan implements Serializable {
				// staff_id scan_date scan_temp
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter @Setter
	    private Long staff_id;
	    	
		@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @Getter @Setter
	    private Date scan_date;	
		
		@Column(name="scan_temp",nullable = false, updatable = false)
	    @Getter @Setter
	    private double scan_temp;
			
		@Column(name="scan_type",nullable = false, updatable = false)
	    @Getter @Setter
	    private String scan_type;
		
		// --------------- GETTERS SETTERS -------------
		
		public Long getStaff_id() {
			return staff_id;
		}

		public void setStaff_id(Long staff_id) {
			this.staff_id = staff_id;
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

		public String getScan_type() {
			return scan_type;
		}

		public void setScan_type(String scan_type) {
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
		// --------------- GETTERS SETTERS -------------
		
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
			return "StaffScanTab [staff_id=" + staff_id + ", scan_date=" + scan_date + ", scan_temp=" + scan_temp
					+ ", scan_type=" + scan_type + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
		}


	    
	
}
