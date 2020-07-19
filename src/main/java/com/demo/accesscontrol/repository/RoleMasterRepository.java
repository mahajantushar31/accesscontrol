package com.demo.accesscontrol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.accesscontrol.entity.RoleMaster;
/**
 * @author Tushar mahajan
 *
 */
@Repository
public interface RoleMasterRepository extends JpaRepository<RoleMaster, Long>{

@Query(value="SELECT * FROM role_master as e",nativeQuery = true)	
public List<RoleMaster> getAllRole()throws Exception;
	
@Query(value="SELECT * FROM role_master e WHERE e.role_Name = :role",nativeQuery = true)
public RoleMaster getRole(@Param("role") String role)throws Exception;
	
}
