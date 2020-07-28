/*===========================
FileName: UserServiceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.service.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.entity.User;
import com.demo.accesscontrol.repository.UserRepository;
import com.demo.accesscontrol.service.UserService;

/**
 * @author Tushar mahajan
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	private final static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository userRepository; 
	/*
	 * @Autowired JpaRepository<User, Long> jpaRepository;
	 */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/*
	 * @Override public User saveUser(User staff) { User user; try {
	 * user=userRepository.save(staff); return user; } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return null; }
	 */
	// @Transactional
	public User saveOrUpdate(User user)  {
		User oldUser;
		try {
			System.out.println(" EMail "+user.getEmail() );
			oldUser=userRepository.getUserByEmail(user.getEmail());
			if(null==oldUser) {		
				user=userRepository.save(user);
			
			}else {
				User newUser=new User();
				newUser=(User) CommonUtil.objectUtilMapper(oldUser, newUser);
				user=(User) CommonUtil.objectUtilMapper(user, newUser);
				//user=EntityManagerFactory.g.merge();
				user.setUser_id(oldUser.getUser_id());
				System.out.println( " before save "+user.toString());
				 user=userRepository.save(user);
				 		
				 //entityManager.persist(user);
				 System.out.println( " before save "+user.toString());
				 //userRepository.deleteById(user.getUser_id());
				// EntityMager em=EntityManagerFactory(); jpaRepository dao.createAud(entity);
				// createUpdateUserDetails(loginId, entity); entity = jpa.merge(entity); return (E) dao.flush(entity);
				
			}
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//logger.error(" ERROR in SAVE  "+e.getStackTrace());
		}
		return null;
	}
	
	@Override
	public List<User> getAllUserDetail() {
		try {
			List staffList = userRepository.getAllUserDetail();
			return staffList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public User getUserById(String id) throws Exception {
		User user;
		try {
			user=userRepository.getUserById(id);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUserByUserNamePass(String userName, String password) throws Exception {
		User user;
		try {
		user=userRepository.getUserByUserNamePass(userName, password);
		return user;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/*Map<String,String> paramMap=new HashMap();
			paramMap.put("email",user.getEmail());
	 * @Override public User getUserByParam(Map<String, String> paramMap) throws
	 * Exception { // TODO Auto-generated method st
	 * user=userRepository.getUserByParam
	 * 
	 * return null; }
	 */
	

}
