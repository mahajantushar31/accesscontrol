/*===========================
FileName: UserToAccessCodeRepository.java
Author:Tushar Mahajan
History:
Date:Jul 29, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.accesscontrol.entity.UserToAccessCodeMap;

/**
 * @author Tushar mahajan
 *
 */
@Repository
public interface UserToAccessCodeMapRepository extends JpaRepository<UserToAccessCodeMap, Long>{
	
	// //  userToAccessCode_id  user_id  access_code  isAccess
		
	@Query(value="SELECT * FROM user_to_access_code_map as e",nativeQuery = true)	
	public List<UserToAccessCodeMap> getAllUserToAccessCodeMapDetail()throws Exception;
		
	@Query(value="SELECT * FROM user_to_access_code_map e WHERE e.user_id = :user_id",nativeQuery = true)
	public UserToAccessCodeMap getUserToAccessCodeMapByUserId(Long user_id) throws Exception;
	
	@Query(value="SELECT * FROM user_to_access_code_map e WHERE e.is_access_grant = :isAccess",nativeQuery = true)
	public List<UserToAccessCodeMap> getAllUserToAccessCodeMapByIsAccessGrant(Integer isAccess) throws Exception;
	
	@Query(value="SELECT * FROM user_to_access_code_map e WHERE e.is_access_grant = :isAccess and e.user_id = :user_id",nativeQuery = true)
	public UserToAccessCodeMap getAllUserToAccessCodeMapByIsAccessGrantAndCode(Integer isAccess,Long user_id) throws Exception;
	
	
	/*
	 * @Query(
	 * value="SELECT * FROM access_point e WHERE e.email = :email and e.password = :password"
	 * ,nativeQuery = true) public AccessPoint getUserByUserNamePass(String email
	 * ,String password) throws Exception;
	 */
	/**/
	

}
