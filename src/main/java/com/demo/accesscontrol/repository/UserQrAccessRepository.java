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

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.accesscontrol.entity.User;
import com.demo.accesscontrol.entity.UserAccess;
import com.demo.accesscontrol.entity.UserQrAccess;

/**
 * @author Tushar mahajan
 *
 */
@Repository
public interface UserQrAccessRepository extends JpaRepository<UserQrAccess, Long>{
	
	
	
	@Query(value="SELECT * FROM user_qr_access as e",nativeQuery = true)	
	public List<UserQrAccess> getAllUserQrAccessDetail()throws Exception;
		
	@Query(value="SELECT * FROM user_qr_access e WHERE e.access_id = :access_id",nativeQuery = true)
	public UserQrAccess getUserQrAccessByAccessId(String access_id) throws Exception;
	
	@Query(value="SELECT * FROM user_qr_access e WHERE e.qr = :qr",nativeQuery = true)
	public UserQrAccess getUserQrAccessByQr(String qr) throws Exception;
	
	/**/
	
	/* 
	static EntityManagerFactory entityManagerFactory =Persistence.createEntityManagerFactory("User");
	// staff_id firstname lastname dob email phone date_of_joining last_active_date
	@Autowired
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	/*-
	static String checkAnd(Integer and){
		
		return (1==and)?" AND ":"";
	}
	
	// email	Role Password	firstname	lastname	dob	phone	date_of_joining	last_active_date
	//@Query(value="SELECT * FROM staff_master e WHERE e.role_Name = :role",nativeQuery = true)
	public default User getStaffByParameter(Map<String,String>  paramMap) {
		String queryString="Select * from User sm ";
		if(paramMap.size()>0) {
			queryString +=" where ";
				Integer and=0;
				if(paramMap.get("email") != null) {
					queryString +=" email =:"+paramMap.get("email");
					and=1;
				}
				if(paramMap.get("role_id") != null) {
					queryString +=checkAnd(and)+" role_id =:"+paramMap.get("role_id");
					and = 1;
				}
				if(paramMap.get("firstname") != null) {
					queryString +=checkAnd(and)+" firstname =:"+paramMap.get("firstname");
					and = 1;
				}
				if(paramMap.get("lastname") != null) {
					queryString +=checkAnd(and)+" lastname =:"+paramMap.get("lastname");
					and = 1;
				}
				if(paramMap.get("dob") != null) {
					queryString +=checkAnd(and)+" dob =:'"+paramMap.get("dob")+"'";
					and = 1;
				}
				if(paramMap.get("date_of_joining") != null) {
					queryString +=checkAnd(and)+" date_of_joining =:'"+paramMap.get("date_of_joining")+"'";
					and = 1;
				}
				if(paramMap.get("last_active_date") != null) {
					queryString +=checkAnd(and)+" last_active_date =:'"+paramMap.get("last_active_date")+"'";
					//and = 1;
				}
		}
		 Query query = (Query) entityManager.createNativeQuery(queryString);
	   entityManager.
		 List<User> list =(List<User>)query.get;
		
		 * for (Object o : list) { if (o instanceof Object[]) {
		 * System.out.println(Arrays.toString((Object[]) o)); } else {
		 * System.out.println(o); } }
		 *-/
		
		return null;  //need to implement  this custo query for this 

	}  */
}
