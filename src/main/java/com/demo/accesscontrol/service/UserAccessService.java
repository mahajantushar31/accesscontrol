/*===========================
FileName: UserAccessService.java
Author:Tushar Mahajan
History:
Date:Jul 21, 2020:created
============================*/

package com.demo.accesscontrol.service;

import java.util.List;

import com.demo.accesscontrol.entity.UserAccess;

/**
 * @author Tushar mahajan
 *
 */
public interface UserAccessService {
	public List<UserAccess> getAllUserAccessDetail() throws Exception;
	
	public UserAccess getUserAccessById(String id) throws Exception;
	
	public UserAccess getUserAccessByAccessName(String access_name) throws Exception; //access_name = email 
	
	public UserAccess saveOrUpdate(UserAccess user_access) throws Exception;
	
	// public UserAccess getUserByParam(Map<String,String> paramMap) throws Exception;

}
