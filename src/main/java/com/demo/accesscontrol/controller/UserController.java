/*===========================
FileName: UserController.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

// import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.dto.UserDto;
import com.demo.accesscontrol.entity.User;
import com.demo.accesscontrol.service.EmailService;
import com.demo.accesscontrol.service.UserService;

// @formatter:on

/**
 * @author Tushar mahajan
 *
 */

@RequestMapping("/user")
@RestController
public class UserController {
	// old: // staff_id firstname lastname dob email phone date_of_joining last_active_date
	
	// new:	email	Role Password	firstname	lastname	dob	phone	date_of_joining	last_active_date	
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	
	@GetMapping("/getAllUserDetail")
	public ResponseEntity<List<User>> getAllUserDetail()  {
		List<User> userList = null;
		try {
			userList = userService.getAllUserDetail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(userList,HttpStatus.OK);
		
	}
	
	@PostMapping("/getUserById")
	public ResponseEntity<User>  getUserById(@Valid  @RequestBody String id){
		User staff = null;
		try {
			staff = userService.getUserById(id);
			return new ResponseEntity(staff,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(staff,HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
		// firstname lastname dob email phone date_of_joining last_active_date
		System.out.println(" sysout "+userDto.toString());
		User user= (User) CommonUtil.objectUtilMapper(userDto, new User());
		// ModelMapper m=new ModelMapper();
		try {
			user = userService.saveOrUpdate(user);
			return new ResponseEntity(user,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  new ResponseEntity(user,HttpStatus.NO_CONTENT);
		
	}
	
	@RequestMapping("/sendInviteEmail")
	public ResponseEntity<String> sendInviteEmail(){   // @RequestBody UserDto staff
		// firstname lastname dob email phone date_of_joining last_active_date
		// System.out.println(" sysout "+staff.toString());
		// User staffMst= (User) CommonUtil.objectUtilMapper(staff, new User());
		// ModelMapper m=new ModelMapper();
		String emailMsg="";
		Map<String,String> emailConfigParam=new HashMap<String,String>();
		try {
			emailMsg = emailService.sendInviteMail(emailConfigParam);
			return new ResponseEntity(emailMsg,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  new ResponseEntity(emailMsg,HttpStatus.NO_CONTENT);
		
	}
	
	
}
