/*===========================
FileName: SystemConfig.java
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
@Table(name = "system_config")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class SystemConfig implements Serializable{

		@Id
		@Getter @Setter
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Integer id; //20
		
		@Column(name = "system_key",nullable = false,unique = true)
		@NotNull
		@Getter @Setter
	    private String systemKey;
		
		@Column(name = "system_value",nullable = false)
		@NotNull
		@Getter @Setter
	    private String systemValue;	// varchar2	50
		
		// ------- GETTES SETTERS --------------
		 public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}

			public String getSystemKey() {
				return systemKey;
			}

			public void setSystemKey(String systemKey) {
				this.systemKey = systemKey;
			}

			public String getSystemValue() {
				return systemValue;
			}

			public void setSystemValue(String systemValue) {
				this.systemValue = systemValue;
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
		
		
		// ------- GETTES SETTERS --------------
		// ----- For Record ---------
		@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @Getter @Setter
	    @CreatedDate
	    private Date createdAt;

	   

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		@Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    @Getter @Setter
	    private Date updatedAt;

		@Override
		public String toString() {
			return "SystemConfig [id=" + id + ", systemKey=" + systemKey + ", systemValue=" + systemValue
					+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
		}

		
	
}
