package com.demo.accesscontrol.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotBlank;
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
@SuppressWarnings("serial")
@Entity
@Table(name = "role_master")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class RoleMaster implements Serializable {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Getter @Setter
	    private Long role_id;
		
		@Column(name = "role_Name",nullable = false,unique = true)
		@NotNull
		@Getter @Setter
	    private String roleName;
	    

		// ----- getters setters -------
		
		
	    public Long getRole_id() {
			return role_id;
		}

		public void setRole_id(Long role_id) {
			this.role_id = role_id;
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

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
			return "RoleTab [role_id=" + role_id + ", roleName=" + roleName + ", createdAt=" + createdAt
					+ ", updatedAt=" + updatedAt + "]";
		}

		
		

		
	}
	

