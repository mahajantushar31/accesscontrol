/*===========================
FileName: UserQrAccess.java
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
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class UserQrAccess implements Serializable {
				// staff_id scan_date scan_temp
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userQrAccess_id;
	    	
		@Column(length=50,nullable = false, updatable = false)
	    private String qr;	
		
		@Column(nullable = false, updatable = false)
	    private Long access_id;
			
		
		// ----- For Record ---------
	/*
	 * @Column(nullable = false, updatable = false)
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Getter @Setter
	 * 
	 * @CreatedDate private Date createdAt;
	 * 
	 * 
	 * @Column(nullable = false)
	 * 
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @LastModifiedDate
	 * 
	 * @Getter @Setter private Date updatedAt;
	 */

		
		// --------------- GETTERS SETTERS -------------
		  public Long getUserQrAccess_id() {
				return userQrAccess_id;
			}

			public void setUserQrAccess_id(Long userQrAccess_id) {
				this.userQrAccess_id = userQrAccess_id;
			}

			public String getQr() {
				return qr;
			}

			public void setQr(String qr) {
				this.qr = qr;
			}

			public Long getAccess_id() {
				return access_id;
			}

			public void setAccess_id(Long access_id) {
				this.access_id = access_id;
			}

			

			@Override
			public String toString() {
				return "UserQrAccess [userQrAccess_id=" + userQrAccess_id + ", qr=" + qr + ", access_id=" + access_id
						//+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt 
						+ "]";
			}
		
		// --------------- GETTERS SETTERS -------------

	    
	
}
