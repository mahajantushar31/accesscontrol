/*===========================
FileName: UserToAccessCode.java
Author:Tushar Mahajan
History:
Date:Jul 29, 2020:created
============================*/

/*===========================
FileName: UserToAccessCode.java
Author:Tushar Mahajan
History:
Date:Jul 29, 2020:created
============================*/

package com.demo.accesscontrol.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Tushar mahajan
 *
 */

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class UserToAccessCodeMap {
										//  userToAccessCode_id  user_id  access_code  isAccess
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userToAccessCode_id;
    	
	@Column(nullable = false, updatable = false,unique=true) //length=50,
    private Long user_id;	
	
	@Column(length=50,  nullable = false, updatable = false)
    private String access_code;
	
	@Column(nullable = false, updatable = false)
    private Integer isAccessGrant=1;                       //   1: access  0 : no access
	
	
	@Column(nullable = false, updatable = false)
	@CreatedDate
    private Date createdAt;


	public Long getUserToAccessCode_id() {
		return userToAccessCode_id;
	}


	public void setUserToAccessCode_id(Long userToAccessCode_id) {
		this.userToAccessCode_id = userToAccessCode_id;
	}


	public Long getUser_id() {
		return user_id;
	}


	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}


	public String getAccess_code() {
		return access_code;
	}


	public void setAccess_code(String access_code) {
		this.access_code = access_code;
	}


	public Integer getIsAccessGrant() {
		return isAccessGrant;
	}


	public void setIsAccessGrant(Integer isAccessGrant) {
		this.isAccessGrant = isAccessGrant;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "UserToAccessCode [userToAccessCode_id=" + userToAccessCode_id + ", user_id=" + user_id
				+ ", access_code=" + access_code + ", isAccessGrant=" + isAccessGrant + ", createdAt=" + createdAt
				+ "]";
	}

	
	
}
