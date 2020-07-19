/*===========================
FileName: RoleMasterController.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accesscontrol.commons.util.CommonUtil;
import com.demo.accesscontrol.dto.RoleMasterDto;
import com.demo.accesscontrol.entity.RoleMaster;
import com.demo.accesscontrol.repository.RoleMasterRepository;
import com.demo.accesscontrol.service.RoleMasterService;

/**
 * @author Tushar mahajan
 *
 */
@RestController
@RequestMapping("/role")
public class RoleMasterController {
	// 	@Autowired	RoleMasterRepository RoleMasterRepository;
	//CommonRepository<RoleMaster> commonRepository;
	
	@Autowired
	RoleMasterService  roleMasterService;
	// get All ROLE
	@GetMapping("/getRoles")
	public ResponseEntity<List<RoleMaster>> getAllRoles(Pageable pageable) {
		List<RoleMaster> roleList=null;
		try {
			roleList = roleMasterService.getAllRole();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return new ResponseEntity(roleList,HttpStatus.OK)   ;
	}
	
	// create a new ROLE/ Register
	@PostMapping("/createRole") //@Valid @RequestBody
	public RoleMaster createNote(@Valid @RequestBody RoleMasterDto roleDto) {
		RoleMaster r=(RoleMaster) CommonUtil.objectUtilMapper(roleDto, new RoleMaster());
				
		System.out.println("role is " +r.toString());
	    try {
			return roleMasterService.save(r) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	/*
	 * @PostMapping("/createRole") //@Valid @RequestBody public RoleMaster
	 * createNote(@Valid @RequestBody RoleMasterDto roleDto) { RoleMaster
	 * r=(RoleMaster) CommonUtil.objectUtilMapper(roleDto, new RoleMaster());
	 * 
	 * System.out.println("role is " +r.toString()); return
	 * RoleMasterRepository.save(r); }
	 */
	
	
}
