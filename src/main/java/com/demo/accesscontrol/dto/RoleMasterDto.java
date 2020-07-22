package com.demo.accesscontrol.dto;

import java.io.Serializable;

/**
 * @author Tushar mahajan
 *
 */

public class RoleMasterDto implements Serializable {
	
    private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    
}
