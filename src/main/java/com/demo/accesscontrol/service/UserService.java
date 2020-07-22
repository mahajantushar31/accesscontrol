/*===========================
FileName: StaffMasterService.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.service;

import java.util.List;
import java.util.Map;

import com.demo.accesscontrol.entity.User;

/**
 * @author Tushar mahajan
 *
 */
public interface UserService {
	public List<User> getAllUserDetail() throws Exception;
		
	public User getUserById(String id) throws Exception;
	
	public User saveOrUpdate(User user) throws Exception;
	
	// public User getUserByParam(Map<String,String> paramMap) throws Exception;
	
}
