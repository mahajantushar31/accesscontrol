/*===========================
FileName: LoginRepository.java
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

import com.demo.accesscontrol.entity.StaffMaster;

/**
 * @author Tushar mahajan
 *
 */
@Repository
public interface StaffMasterRepository extends JpaRepository<StaffMaster, Long>{
	/*
	static EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("StaffMaster");
	// staff_id firstname lastname dob email phone date_of_joining last_active_date
	@Autowired
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	*/
	
	
	@Query(value="SELECT * FROM staff_master as e",nativeQuery = true)	
	public List<StaffMaster> getAllStaffDetail()throws Exception;
		
	@Query(value="SELECT * FROM staff_master e WHERE e.staff_id = :id",nativeQuery = true)
	public StaffMaster getStaffById(String id) throws Exception;
	
	
	/*
	
	//@Query(value="SELECT * FROM staff_master e WHERE e.role_Name = :role",nativeQuery = true)
	public default StaffMaster getStaffByParameter(Map<String,String>  paramMap) {
		String queryString="Select * from staff_master sm ";
		if(paramMap.size()>0)
			queryString +=" where ";
		
		if(paramMap.get("staff_id") != null)
			queryString +=" staff_id =:"+paramMap.get("staff_id");
		
		 Query query = (Query) entityManager.createNativeQuery(queryString);
	   
		 /-* List<StaffMaster> list =(List<StaffMaster>)query.;
		
		 * for (Object o : list) { if (o instanceof Object[]) {
		 * System.out.println(Arrays.toString((Object[]) o)); } else {
		 * System.out.println(o); } }
		 *=/
		
		return null;  //need to implement  this custo query for this 

	}*/
}
