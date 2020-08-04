/*===========================
FileName: AccessPointRepository.java
Author:Tushar Mahajan
History:
Date:Jul 17, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.accesscontrol.entity.AccessPoint;
import com.demo.accesscontrol.entity.User;

/**
 * @author Tushar mahajan
 *
 */
@Repository
public interface AccessPointRepository extends JpaRepository<AccessPoint, Long>{
	
	// accessPoint_id  accessPoint_name  accessPoint_code[Unique]  isEnable
		
	@Query(value="SELECT * FROM access_point as e ",nativeQuery = true)	
	public List<AccessPoint> getAllAccessPointDetail()throws Exception;
		
	@Query(value="SELECT * FROM access_point e WHERE e.access_point_code = :accessPointCode ",nativeQuery = true)
	public AccessPoint getAccessPointByAccessPointCode(String accessPointCode) throws Exception;
	
	@Query(value="SELECT * FROM access_point e WHERE e.is_available = :isAvailable ",nativeQuery = true)
	public List<AccessPoint> getAllAccessPointByIsAvailable(Integer isAvailable) throws Exception;
	
	@Query(value="SELECT * FROM access_point e WHERE e.is_available = :isAvailable AND e.access_point_code = :accessPointCode ",nativeQuery = true)
	public AccessPoint getAllAccessPointByIsAvailableAndCode(Integer isAvailable,String accessPointCode) throws Exception;
	
	
	/*
	 * @Query(
	 * value="SELECT * FROM access_point e WHERE e.email = :email and e.password = :password"
	 * ,nativeQuery = true) public AccessPoint getUserByUserNamePass(String email
	 * ,String password) throws Exception;
	 */
	/**/
	

}
