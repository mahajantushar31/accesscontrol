/*===========================
FileName: StaffController.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accesscontrol.commons.util.CommonUtil;
import com.demo.accesscontrol.dto.StaffMasterDto;
import com.demo.accesscontrol.entity.StaffMaster;
import com.demo.accesscontrol.service.StaffMasterService;

/**
 * @author Tushar mahajan
 *
 */

@RequestMapping("/staff")
@RestController
public class StaffMasterController {
	
	// staff_id firstname lastname dob email phone date_of_joining last_active_date
	@Autowired
	StaffMasterService staffMasterService;
	
	@GetMapping("/getAllStaffDetail")
	public ResponseEntity<List<StaffMaster>> getAllStaffDetail()  {
		List<StaffMaster> staffMasterList = null;
		try {
			staffMasterList = staffMasterService.getAllStaffDetail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(staffMasterList,HttpStatus.OK);
		
	}
	
	@PostMapping("/getStaffById")
	public ResponseEntity<StaffMaster>  getStaffById(@Valid  @RequestBody String id){
		StaffMaster staff;
		try {
			staff = staffMasterService.getStaffById(id);
			return new ResponseEntity(staff,HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/saveStaff")
	public ResponseEntity<StaffMaster> saveStaff(@Valid @RequestBody StaffMasterDto staff){
		
		// firstname lastname dob email phone date_of_joining last_active_date
		System.out.println(" sysout "+staff.toString());
		StaffMaster staffMst= (StaffMaster) CommonUtil.objectUtilMapper(staff, new StaffMaster());
		try {
			staffMst = staffMasterService.saveStaff(staffMst);
			return new ResponseEntity(staffMst,HttpStatus.OK) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
