/*===========================
FileName: UserToAccessCodeMapServiceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.entity.UserToAccessCodeMap;
import com.demo.accesscontrol.repository.UserToAccessCodeMapRepository;
import com.demo.accesscontrol.service.UserToAccessCodeMapService;

/**
 * @author Tushar mahajan
 *
 */
@Service("userToAccessCodeMapService")
public class UserToAccessCodeMapServiceImpl implements UserToAccessCodeMapService{

	private final static Logger logger=LoggerFactory.getLogger(UserToAccessCodeMapServiceImpl.class);
	@Autowired
	UserToAccessCodeMapRepository userToAccessCodeMapRepository; 
	
	
	@Override
	public UserToAccessCodeMap saveOrUpdate(UserToAccessCodeMap userToAccessCodeMap) throws Exception {
		UserToAccessCodeMap oldUserToAccessCodeMap;
		try {
			System.out.println(" UserToAccessCodeMap code "+userToAccessCodeMap.getAccess_code()+" ");
			oldUserToAccessCodeMap=userToAccessCodeMapRepository.getUserToAccessCodeMapByUserId(userToAccessCodeMap.getUser_id());
			if(null==oldUserToAccessCodeMap) {		
				userToAccessCodeMap=userToAccessCodeMapRepository.save(userToAccessCodeMap);
			
			}else {
					UserToAccessCodeMap newUserToAccessCodeMap=new UserToAccessCodeMap();
					newUserToAccessCodeMap=(UserToAccessCodeMap) CommonUtil.objectUtilMapper(oldUserToAccessCodeMap, newUserToAccessCodeMap);
					userToAccessCodeMap=(UserToAccessCodeMap) CommonUtil.objectUtilMapper(userToAccessCodeMap, newUserToAccessCodeMap);
					//user=EntityManagerFactory.g.merge();
					userToAccessCodeMap.setUserToAccessCode_id(oldUserToAccessCodeMap.getUserToAccessCode_id());
					//System.out.println( " before save "+userToAccessCode.toString());
					userToAccessCodeMap=userToAccessCodeMapRepository.save(userToAccessCodeMap);
					//System.out.println( " before save "+userToAccessCode.toString());
			}
			return userToAccessCodeMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//logger.error(" ERROR in SAVE  "+e.getStackTrace());
		}
		return null;
	}

	@Override
	public UserToAccessCodeMap getUserToAccessCodeMapByUserId(Long user_id)  {
		UserToAccessCodeMap userToAccessCodeMap;
		try {
			userToAccessCodeMap=userToAccessCodeMapRepository.getUserToAccessCodeMapByUserId(user_id);
		return userToAccessCodeMap;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserToAccessCodeMap> getAllUserToAccessCodeMapByIsAccessGrant(Integer isAccessGrant) {
		List<UserToAccessCodeMap> userToAccessCodeMapList;
		try {
			userToAccessCodeMapList=userToAccessCodeMapRepository.getAllUserToAccessCodeMapByIsAccessGrant(isAccessGrant);
			return userToAccessCodeMapList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserToAccessCodeMap getUserToAccessCodeMapByIsAccessGrantAndCode(Integer isAccessGrant, Long user_id)
			throws Exception {
		UserToAccessCodeMap userToAccessCodeMap;
		try {
			userToAccessCodeMap = userToAccessCodeMapRepository.getAllUserToAccessCodeMapByIsAccessGrantAndCode(isAccessGrant, user_id);
			return userToAccessCodeMap;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
