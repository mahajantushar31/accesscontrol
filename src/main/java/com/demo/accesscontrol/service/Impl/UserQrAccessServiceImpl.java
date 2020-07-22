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
import org.springframework.stereotype.Service;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.entity.User;
import com.demo.accesscontrol.entity.UserAccess;
import com.demo.accesscontrol.entity.UserQrAccess;
import com.demo.accesscontrol.repository.UserQrAccessRepository;
import com.demo.accesscontrol.service.UserQrAccessService;

/**
 * @author Tushar mahajan
 *
 */
@Service("userQrAccessService")
public class UserQrAccessServiceImpl implements UserQrAccessService{

	@Autowired
	UserQrAccessRepository userQrAccessRepository; 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/*
	 * @Override public User saveUser(User staff) { User user; try {
	 * user=userRepository.save(staff); return user; } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return null; }
	 */
	// @Transactional
	public UserQrAccess saveOrUpdate(UserQrAccess userQrAccess)  {
		UserQrAccess oldUserQrAccess;
		try {
			
			oldUserQrAccess=userQrAccessRepository.getUserQrAccessByQr(userQrAccess.getQr()); //getUserByParam(paramMap);
			
			if(null==oldUserQrAccess) {		
				userQrAccess=userQrAccessRepository.save(userQrAccess);
			
			}else {
				UserQrAccess newUsewQrAccess=new UserQrAccess();
				newUsewQrAccess=(UserQrAccess) CommonUtil.objectUtilMapper(oldUserQrAccess, newUsewQrAccess);
				userQrAccess=(UserQrAccess) CommonUtil.objectUtilMapperExceptnNullOrBlank(userQrAccess, newUsewQrAccess);
				//user=EntityManagerFactory.g.merge();
				userQrAccess.setUserQrAccess_id(oldUserQrAccess.getUserQrAccess_id());
				System.out.println( " before save "+userQrAccess.toString());
				 userQrAccess=userQrAccessRepository.save(userQrAccess);
				// entityManager.persist(userQrAccess);
				 System.out.println( " before save "+userQrAccess.toString());
				 //userRepository.deleteById(user.getUser_id());
				// EntityMager em=EntityManagerFactory(); jpaRepository dao.createAud(entity);
				// createUpdateUserDetails(loginId, entity); entity = jpa.merge(entity); return (E) dao.flush(entity);
				
			}
			return userQrAccess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<UserQrAccess> getAllUserQrAccessDetail() {
		try {
			List userAccessList = userQrAccessRepository.getAllUserQrAccessDetail();
			return userAccessList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public UserQrAccess getUserQrAccessById(String access_id) throws Exception {
		UserQrAccess userQrAccess;
		try {
			userQrAccess=userQrAccessRepository.getUserQrAccessByAccessId(access_id);
			return userQrAccess;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/*
	 * Map<String,String> paramMap=new HashMap();
	 * paramMap.put("access_id",userAccess.getAccess_name());
	 */
	

}
