/*===========================
FileName: UserToAccessCodeController.java
Author:Tushar Mahajan
History:
Date:Jul 31, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.controller;

import java.util.List;

// import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.dto.ResponseDto;
import com.demo.accesscontrol.dto.UserToAccessCodeMapDto;
import com.demo.accesscontrol.entity.UserToAccessCodeMap;
import com.demo.accesscontrol.service.UserToAccessCodeMapService;

// @formatter:on

/**
 * @author Tushar mahajan
 *
 */

@RequestMapping("/userToAccessCode")
@RestController
public class UserToAccessCodeMapController {
	// old: // staff_id firstname lastname dob email phone date_of_joining last_active_date
	
	// new:	email	Role Password	firstname	lastname	dob	phone	date_of_joining	last_active_date	
	
	@Autowired
	UserToAccessCodeMapService userToAccessCodeMapService;
	
//  userToAccessCode_id  user_id  access_code  isAccess
	
	@RequestMapping("/saveUserToAccessCodeUniqueRecord")
	public ResponseDto saveUserToAccessCodeMap(@RequestBody UserToAccessCodeMapDto userToAccessCodeMapDto) {
		UserToAccessCodeMap userToAccessCodeMap = null;
		Integer user_id;
		ResponseDto responseDto=new ResponseDto();
		try {
		
			userToAccessCodeMap=(UserToAccessCodeMap) CommonUtil.objectUtilMapper(userToAccessCodeMapDto, new UserToAccessCodeMap());
			userToAccessCodeMap= userToAccessCodeMapService.saveOrUpdate(userToAccessCodeMap);
			if(null!=userToAccessCodeMap) {
				responseDto.setResponseCode(200);
				responseDto.setResponseMsg(" Saved successfull ");
				responseDto.setResponseObject(userToAccessCodeMap);
			}else {
				// responseDto.setResponseCode(400);
				responseDto.setResponseMsg(" Error while Saving record");
				responseDto.setResponseObject(userToAccessCodeMapDto);
			}
	
		}catch(Exception e) {
			e.getStackTrace();
			responseDto.setResponseMsg(" Error while Saving record");
			responseDto.setResponseObject(userToAccessCodeMapDto);
		}
		
		return responseDto;
	}
	
	@RequestMapping("/getUserMappedToAccessCodeByUserId")
	public ResponseDto getUserToAccessCodeMapByUserId(@RequestBody UserToAccessCodeMapDto userToAccessCodeMapDto) {
		UserToAccessCodeMap userToAccessCodeMap;
		Long user_id;
		ResponseDto responseDto=new ResponseDto();
		try {
			user_id=userToAccessCodeMapDto.getUser_id();
			userToAccessCodeMap=userToAccessCodeMapService.getUserToAccessCodeMapByUserId(user_id);
			if(null!=userToAccessCodeMap) {
				responseDto.setResponseCode(200);
				responseDto.setResponseMsg(" User found for given userId ");
				responseDto.setResponseObject(userToAccessCodeMap);
			}else {
				// responseDto.setResponseCode(200);
				responseDto.setResponseMsg(" User Not found for given userId ");
				responseDto.setResponseObject(userToAccessCodeMap);
			}
			
		}catch(Exception e) {
			e.getStackTrace();
			responseDto.setResponseMsg(" Error while getting record for userId ");
			responseDto.setResponseObject(userToAccessCodeMapDto);
		}
		
		return responseDto;
	}
	
	@RequestMapping("/getAllUserMappedToAccessCodeMapByIsAccessGrant")
	public ResponseDto getAllUserMappedToAccessCodeMapByIsAccessGrant(@RequestBody  UserToAccessCodeMapDto userToAccessCodeMapDto) {
		List<UserToAccessCodeMap> userToAccessCodeMapList;
		Integer isAccessGrant;
		ResponseDto responseDto=new ResponseDto();
		try {
			isAccessGrant =userToAccessCodeMapDto.getIsAccessGrant();
			 if(null!=isAccessGrant ) {
					userToAccessCodeMapList=userToAccessCodeMapService.getAllUserToAccessCodeMapByIsAccessGrant(isAccessGrant);
					if(null!=userToAccessCodeMapList) {
						responseDto.setResponseCode(200);
						responseDto.setResponseMsg(" User found for given userId ");
						responseDto.setResponseObject(userToAccessCodeMapList);
					}else {
						// responseDto.setResponseCode(200);
						responseDto.setResponseMsg(" User Not found for given criteria ");
						responseDto.setResponseObject(userToAccessCodeMapDto);
					}	
			}else {
				
				responseDto.setResponseMsg(" IsAccessGrant Flag received null : wrong input ");
				responseDto.setResponseObject(userToAccessCodeMapDto);
			}

		}catch(Exception e) {
			e.getStackTrace();
			responseDto.setResponseMsg(" User Not found for given criteria ");
			responseDto.setResponseObject(userToAccessCodeMapDto);
		}
		
		return responseDto;
	}
	
	@RequestMapping("/getUserAccessCodeMapByUserIdAndIsAccessGrantFlag")
	public ResponseDto getUserAccessCodeMapByUserIdAndIsAccessGrantFlag(@RequestBody  UserToAccessCodeMapDto userToAccessCodeMapDto) {
		Integer isAccessGrant;
		Long user_id;
		ResponseDto responseDto=new ResponseDto();
		UserToAccessCodeMap userToAccessCodeMap;

			try {
				//isAccessGrant=userToAccessCodeMapDto.getIsAccessGrant();
				user_id=userToAccessCodeMapDto.getUser_id();
				isAccessGrant =userToAccessCodeMapDto.getIsAccessGrant();
				 if(null!=isAccessGrant && null!=user_id ) {
						userToAccessCodeMap=userToAccessCodeMapService.getUserToAccessCodeMapByIsAccessGrantAndCode(isAccessGrant, user_id);
						if(null!=userToAccessCodeMap) {
							responseDto.setResponseCode(200);
							responseDto.setResponseMsg(" User found for given userId ");
							responseDto.setResponseObject(userToAccessCodeMap);
						}else {
							// responseDto.setResponseCode(200);
							responseDto.setResponseMsg(" User Not found for given criteria ");
							responseDto.setResponseObject(userToAccessCodeMapDto);
						}	
				}else {
					
					responseDto.setResponseMsg(" IsAccessGrant Flag received null : wrong input ");
					responseDto.setResponseObject(userToAccessCodeMapDto);
				}

			}catch(Exception e) {
				e.getStackTrace();
				responseDto.setResponseMsg(" User Not found for given criteria ");
				responseDto.setResponseObject(userToAccessCodeMapDto);
			}
		return responseDto;
	}
	
	
	@RequestMapping("/grantRevokeUserAccessCodeMapByUserId")
	public ResponseDto grantRevokeUserAccessCodeMapByUserId(@RequestBody  UserToAccessCodeMapDto userToAccessCodeMapDto) {
		Integer isAccessGrant;
		Long user_id;
	    String msg="";
		ResponseDto responseDto=new ResponseDto();
		UserToAccessCodeMap userToAccessCodeMap;

			try {
				//isAccessGrant=userToAccessCodeMapDto.getIsAccessGrant();
				user_id=userToAccessCodeMapDto.getUser_id();
				
				isAccessGrant =userToAccessCodeMapDto.getIsAccessGrant();
				 if(null!=user_id ) {
						userToAccessCodeMap=userToAccessCodeMapService.getUserToAccessCodeMapByUserId(user_id);
						if(null!=userToAccessCodeMap) {
							if(1==userToAccessCodeMap.getIsAccessGrant()) {
								isAccessGrant=0;
								msg="user with userId"+user_id+" revoked  access";
							}else {
								isAccessGrant=1;
								msg="user with userId"+user_id+" granted access";
							}
							userToAccessCodeMap.setIsAccessGrant(isAccessGrant);
							userToAccessCodeMap=userToAccessCodeMapService.saveOrUpdate(userToAccessCodeMap);
							if(null!=userToAccessCodeMap) {
								responseDto.setResponseCode(200);
								responseDto.setResponseMsg(msg);
								responseDto.setResponseObject(userToAccessCodeMap);
							}else {
								responseDto.setResponseMsg(" error while applying grant revoke opertion ");
								responseDto.setResponseObject(userToAccessCodeMap);
							}
						}else {
							// responseDto.setResponseCode(200);
							responseDto.setResponseMsg(" User Access Entry not found , "
									+ "Please add user access in userToAccessCodeMap Master then grant revoke can be performed");
							responseDto.setResponseObject(userToAccessCodeMapDto);
						}	
				}else {
					
					responseDto.setResponseMsg(" user id  received null : wrong input ");
					responseDto.setResponseObject(userToAccessCodeMapDto);
				}

			}catch(Exception e) {
				e.getStackTrace();
				responseDto.setResponseMsg(" User Not found for given criteria ");
				responseDto.setResponseObject(userToAccessCodeMapDto);
			}
		return responseDto;
	}
	
	

}
