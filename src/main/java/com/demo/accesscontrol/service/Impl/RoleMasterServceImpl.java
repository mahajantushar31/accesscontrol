/*===========================
FileName: RoleMasterServceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.accesscontrol.entity.RoleMaster;
import com.demo.accesscontrol.repository.RoleMasterRepository;
import com.demo.accesscontrol.service.RoleMasterService;

/**
 * @author Tushar mahajan
 *
 */
@Service("roleMasterService")
public class RoleMasterServceImpl implements RoleMasterService {

	private static final Logger logger = LoggerFactory.getLogger(RoleMasterServceImpl.class);
	@Autowired
	RoleMasterRepository RoleMasterRepository;
	
	@Override
	public RoleMaster getRole(RoleMaster roleMaster) {
		System.out.println("role is " +roleMaster.toString());
	    return RoleMasterRepository.save(roleMaster);
	}

	@Override
	public List<RoleMaster> getAllRole() {
		List<RoleMaster> roleList=new ArrayList<RoleMaster>();
		try {
			roleList = RoleMasterRepository.getAllRole();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roleList;
	}

	@Override
	public RoleMaster save(RoleMaster roleMaster) {
		try {
		RoleMasterRepository.save(roleMaster);
		return RoleMasterRepository.save(roleMaster);
		}catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}

}
