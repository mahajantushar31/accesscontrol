/*===========================
FileName: UserServiceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.entity.UserAccess;
import com.demo.accesscontrol.entity.UserQrAccess;
import com.demo.accesscontrol.repository.UserAccessRepository;
import com.demo.accesscontrol.service.UserAccessService;

/**
 * @author Tushar mahajan
 *
 */
@Service("userAccessService")
public class UserAccessServiceImpl implements UserAccessService{

	@Autowired
	UserAccessRepository userAccessRepository; 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/*
	 * @Override public User saveUser(User staff) { User user; try {
	 * user=userRepository.save(staff); return user; } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return null; }
	 */
	// @Transactional
	
	public UserAccess saveOrUpdate(UserAccess userAccess)  {
		UserAccess oldUserAccess;
		
		try {
			
			oldUserAccess=userAccessRepository.getUserAccessByAccessName(userAccess.getAccess_name());
			if(null==oldUserAccess) {		
				userAccess=userAccessRepository.save(userAccess);
			
			}else {
				UserAccess newUserAccess=new UserAccess();
				newUserAccess=(UserAccess) CommonUtil.objectUtilMapper(oldUserAccess, newUserAccess);
				userAccess=(UserAccess) CommonUtil.objectUtilMapper(userAccess, newUserAccess);
				//user=EntityManagerFactory.g.merge();
				userAccess.setAccess_id(oldUserAccess.getAccess_id());
				System.out.println( " before save "+userAccess.toString());
				userAccess=userAccessRepository.save(userAccess); 
				 System.out.println( " after save "+userAccess.toString());
				 //userRepository.deleteById(user.getUser_id());
				// EntityMager em=EntityManagerFactory(); jpaRepository dao.createAud(entity);
				// createUpdateUserDetails(loginId, entity); entity = jpa.merge(entity); return (E) dao.flush(entity);
				
			}
			return userAccess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<UserAccess> getAllUserAccessDetail() {
		try {
			List userAccessList = userAccessRepository.getAllUserAccessDetail();
			return userAccessList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public UserAccess getUserAccessById(String id) throws Exception {
		UserAccess userAccess;
		try {
			userAccess=userAccessRepository.getUserAccessById(id);
			return userAccess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public UserAccess getUserAccessByAccessName(String access_name) throws Exception{ //access_name = email 
		UserAccess userAccess;
		try {
			userAccess=userAccessRepository.getUserAccessByAccessName(access_name);
			return userAccess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	/*
	 * @Override public UserAccess getUserByParam(Map<String, String> paramMap)
	 * throws Exception { // TODO Auto-generated method st Map<String,String>
	 * paramMap=new HashMap();
	 * paramMap.put("access_name",userAccess.getAccess_name());
	 * 
	 * return null; }
	 */
	

}
