/*===========================
FileName: AccessPointController.java
Author:Tushar Mahajan
History:
Date:Jul 31, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.controller;

import java.util.List;

import javax.validation.Valid;

// import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.dto.AccessPointDto;
import com.demo.accesscontrol.dto.ResponseDto;
import com.demo.accesscontrol.dto.UserDto;
import com.demo.accesscontrol.entity.AccessPoint;
import com.demo.accesscontrol.service.AccessPointService;

// @formatter:on

/**
 * @author Tushar mahajan
 *
 */

@RequestMapping("/accessPoint")
@RestController
public class AccessPointController {
		
	
	@Autowired
	AccessPointService accessPointService;
	
	
	@GetMapping("/getAllAccessPointDetail")
	public ResponseDto getAllAccessPointDetail()  {
		ResponseDto responseDto=new ResponseDto();
		List<AccessPoint> accessPointList = null;
		try {
			accessPointList = accessPointService.getAllAccessPointDetail();
			if(null!=accessPointList && !accessPointList.isEmpty()) {
				responseDto.setResponseObject(accessPointList);
				responseDto.setResponseMsg(" Success  ");
			}else {
				responseDto.setResponseObject(accessPointList);
				responseDto.setResponseMsg(" No records found  ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseDto.setResponseMsg(" Error while getting records ");
		}
		return responseDto;
		
	}
	
	@RequestMapping("/saveAccessPoint")
	public ResponseDto saveAccessPoint(@RequestBody AccessPointDto accessPointDto){
		ResponseDto responseDto=new ResponseDto();
		System.out.println(" accessPointDto  "+accessPointDto.toString());
		AccessPoint oldAccessPoint;
		AccessPoint accessPoint= (AccessPoint) CommonUtil.objectUtilMapper(accessPointDto, new AccessPoint());
		String accessPointCode=""; 
		try {
			accessPointCode=accessPointDto.getAccessPoint_code();
			if(null!=accessPointCode && !accessPointCode.isEmpty()) {
			/*	oldAccessPoint =accessPointService.getAccessPointByAccessPointCode(accessPointCode);
				if (null != oldAccessPoint && 1==oldAccessPoint.getIsAvailable()) {
					responseDto.setResponseObject(oldAccessPoint);
					responseDto.setResponseMsg("AccessPointCode already present Please use different ");		
				}else {*/
						accessPoint =accessPointService.saveOrUpdate(accessPoint);
						if (null!=accessPoint) {
							responseDto.setResponseObject(accessPoint);
							responseDto.setResponseMsg("AccessPpoint added succesful");
						}else {
							responseDto.setResponseObject(accessPointDto);
							responseDto.setResponseMsg(" Error while saving Access Point ");
						}
			
			// * }
			}else {	
				// "AccessPointCode present and unavailabe for use, Please  make it available from accessPoint master"
			  responseDto.setResponseObject(accessPoint);
			  responseDto.setResponseMsg("Null  input "); 
			 }
			 

			return responseDto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseDto.setResponseMsg(" Error while saving Access Point ");
		}
		return  responseDto;	
	}
	

	@RequestMapping("/getAccessPointByIsAvailable") // for  isAvailable=1 (available)           isAvailbale=0 (unAvailable)    
	public ResponseDto getAccessPointByIsEnable(@RequestBody AccessPointDto  accessPointDto ){
		ResponseDto responseDto=new ResponseDto();
		List<AccessPoint> accessPointList = null;
		Integer isAvailable;
		try {
			isAvailable=accessPointDto.getIsAvailable();
			if(null!=isAvailable && (0==isAvailable || 1==isAvailable)) {
				accessPointList = accessPointService.getAccessPointByIsAvailable(isAvailable);
				if(null!=accessPointList && !accessPointList.isEmpty()) {
					responseDto.setResponseObject(accessPointList);
					responseDto.setResponseMsg(" Success  ");
				}else {
					responseDto.setResponseObject(accessPointList);
					responseDto.setResponseMsg(" No records found  ");
				}
			}else {
				// responseDto.setResponseObject(accessPointList);
				responseDto.setResponseMsg(" isEnable received invalid input   ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			responseDto.setResponseMsg(" Error while getting records ");
		}
		return responseDto;		
	}
	
	
	@PostMapping("/getAccessPointByIdAccessPointCode")
	public ResponseDto  getAccessPointByAccessPointCode(@Valid  @RequestBody AccessPointDto accessPointDto){
		AccessPoint accessPoint = null;
		ResponseDto responseDto=new ResponseDto();
		String accessPointCode="";
		try {
			accessPointCode=accessPointDto.getAccessPoint_code();
			if(null!=accessPointCode && !accessPointCode.trim().isEmpty()) {
				accessPoint = accessPointService.getAccessPointByAccessPointCode(accessPointCode);
				if(null!=accessPoint) {
					responseDto.setResponseObject(accessPoint);
					responseDto.setResponseMsg("AccessPoint_Code present for "+accessPointCode);
				}else {
					//responseDto.setResponseObject(accessPoint);
					responseDto.setResponseMsg("AccessPoint_Code not present for this code "+accessPointCode);
				}
			}else {
				responseDto.setResponseObject(accessPoint);
				responseDto.setResponseMsg(" accessPoint_Code is null ");
			}
			return responseDto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseDto.setResponseObject(accessPoint);
			responseDto.setResponseMsg("Error geting accessPoint_Code ");
		}
		return responseDto;
	}
	
	@PostMapping("/makeAccessPointAvailableOrUnavailable")
	public ResponseDto  makeAccessPointAvailableOrUnavailable(@Valid  @RequestBody AccessPointDto accessPointDto){
		AccessPoint accessPoint = null;
		ResponseDto responseDto=new ResponseDto();
		String accessPointCode="";
		Integer isAvailable;
		String msg="";
		try {
			accessPointCode=accessPointDto.getAccessPoint_code();
			//isAvailable=accessPointDto.getIsAvailable();
			if(null!=accessPointCode && !accessPointCode.trim().isEmpty()) { //&& (null!=isAvailable && (0==isAvailable || 1==isAvailable)) ) {
				accessPoint = accessPointService.getAccessPointByAccessPointCode(accessPointCode);
				if(null!=accessPoint) {
					if(1==accessPoint.getIsAvailable()) {
						isAvailable=0;
						msg=" AccessPoint is now unavailable succesfully";
					}else {
						isAvailable=1;
						msg=" AccessPoint is now available succesfully";
					}
					accessPoint.setIsAvailable(isAvailable);
					accessPoint=accessPointService.saveOrUpdate(accessPoint);
					String status=(1==isAvailable)?"Available":"Unavailable";
					if (null==accessPoint){
						msg="Error while making record : "+status;
					}
					responseDto.setResponseObject(accessPoint);
					responseDto.setResponseMsg(msg);
				}else {
					//responseDto.setResponseObject(accessPoint);
					responseDto.setResponseMsg("AccessPoint_Code not present for this code "+accessPointCode);
				}
			}else {
				responseDto.setResponseObject(accessPoint);
				responseDto.setResponseMsg(" accessPoint_Code is null ");
			}
			return responseDto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			responseDto.setResponseObject(accessPoint);
			responseDto.setResponseMsg("Error geting accessPoint_Code ");
		}
		return responseDto;
	}
	
}
