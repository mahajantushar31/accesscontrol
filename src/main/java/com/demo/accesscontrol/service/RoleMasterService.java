/*===========================
FileName: RoleTabService.java
Author:Tushar Mahajan
History:
Date:Jul 13, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.service;

import java.util.List;

import com.demo.accesscontrol.entity.RoleMaster;

/**
 * @author Tushar mahajan
 *
 */
public interface RoleMasterService {
	
	
	public List<RoleMaster> getAllRole()throws Exception;
	
	public RoleMaster getRole(RoleMaster roleMaster)throws Exception;
	
	public RoleMaster save(RoleMaster roleMaster)throws Exception;
	
}
