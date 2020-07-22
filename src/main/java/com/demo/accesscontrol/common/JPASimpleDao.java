package com.demo.accesscontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.accesscontrol.entity.RoleMaster;

/**
 * @author Tushar mahajan
 * @param 
 *
 */@Repository
public interface CommonRepository extends JpaRepository<RoleMaster, Long>{

}
