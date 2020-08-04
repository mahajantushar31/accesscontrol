/*===========================
FileName: AccessPointService.java
Author:Tushar Mahajan
History:
Date:Jul 29, 2020:created
============================*/

package com.demo.accesscontrol.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.demo.accesscontrol.entity.AccessPoint;
import com.demo.accesscontrol.entity.User;

/**
 * @author Tushar mahajan
 *
 */
public interface AccessPointService {
	
	
	public AccessPoint saveOrUpdate(AccessPoint accessPoint) throws Exception;
	
	public List<AccessPoint> getAllAccessPointDetail()throws Exception;
		
	public AccessPoint getAccessPointByAccessPointCode(String accessPointCode) throws Exception;
	
	public List<AccessPoint> getAccessPointByIsAvailable(Integer isAvailable) throws Exception;
	
}
