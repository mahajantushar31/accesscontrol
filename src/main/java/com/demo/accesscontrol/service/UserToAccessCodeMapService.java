/*===========================
FileName: UserToAccessCodeMapService.java
Author:Tushar Mahajan
History:
Date:Jul 31, 2020:created
============================*/

package com.demo.accesscontrol.service;

import java.util.List;

import com.demo.accesscontrol.entity.UserToAccessCodeMap;

/**
 * @author Tushar mahajan
 *
 */
public interface UserToAccessCodeMapService {
	
	
	public UserToAccessCodeMap saveOrUpdate(UserToAccessCodeMap userToAccessCodeMap) throws Exception;
	
	public UserToAccessCodeMap getUserToAccessCodeMapByUserId(Long user_id) throws Exception;
	
	public List<UserToAccessCodeMap> getAllUserToAccessCodeMapByIsAccessGrant(Integer isAccessGrant) throws Exception;
	
	public UserToAccessCodeMap getUserToAccessCodeMapByIsAccessGrantAndCode(Integer isAccessGrant,Long user_id) throws Exception;


	
	
	
}
