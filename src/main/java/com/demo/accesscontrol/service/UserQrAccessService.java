/*===========================
FileName: UserAccessService.java
Author:Tushar Mahajan
History:
Date:Jul 21, 2020:created
============================*/

package com.demo.accesscontrol.service;

import java.util.List;
import java.util.Map;

import com.demo.accesscontrol.entity.UserQrAccess;

/**
 * @author Tushar mahajan
 *
 */
public interface UserQrAccessService {
	public List<UserQrAccess> getAllUserQrAccessDetail() throws Exception;
	
	public UserQrAccess getUserQrAccessById(String id) throws Exception;
	
	public UserQrAccess saveOrUpdate(UserQrAccess user_access) throws Exception;
	
	//public UserQrAccess getUserByParam(Map<String,String> paramMap) throws Exception;

}
