/*===========================
FileName: AccessPointServiceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.entity.AccessPoint;
import com.demo.accesscontrol.repository.AccessPointRepository;
import com.demo.accesscontrol.service.AccessPointService;

/**
 * @author Tushar mahajan
 *
 */
@Service("accessPointService")
public class AccessPointServiceImpl implements AccessPointService{

	private final static Logger logger=LoggerFactory.getLogger(AccessPointServiceImpl.class);
	@Autowired
	AccessPointRepository accessPointRepository; 
	
// Transactional
	public AccessPoint saveOrUpdate(AccessPoint accessPoint) {
		AccessPoint oldAccessPoint;
		try {
			System.out.println(" accessPoint code "+accessPoint.getAccessPoint_code());
			System.out.println( " before save "+accessPoint.toString());
			oldAccessPoint=accessPointRepository.getAccessPointByAccessPointCode(accessPoint.getAccessPoint_code());
			if(null==oldAccessPoint) {		
				accessPoint=accessPointRepository.save(accessPoint);
			
			}else {
					AccessPoint newAccessPoint=new AccessPoint();
					newAccessPoint=(AccessPoint) CommonUtil.objectUtilMapper(oldAccessPoint, newAccessPoint);
					accessPoint=(AccessPoint) CommonUtil.objectUtilMapper(accessPoint, newAccessPoint);
					//user=EntityManagerFactory.g.merge();
					accessPoint.setAccessPoint_id(oldAccessPoint.getAccessPoint_id());

					accessPoint=accessPointRepository.save(accessPoint);
					System.out.println( " before save "+accessPoint.toString());
			}
			return accessPoint;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//logger.error(" ERROR in SAVE  "+e.getStackTrace());
		}
		return null;
	}
	
	@Override
	public List<AccessPoint> getAllAccessPointDetail() throws Exception {
		try {
			List accessPointList = accessPointRepository.getAllAccessPointDetail();
			return accessPointList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccessPoint getAccessPointByAccessPointCode(String accessPointCode) throws Exception {
		AccessPoint user;
		try {
			user=accessPointRepository.getAccessPointByAccessPointCode(accessPointCode);
		return user;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccessPoint> getAccessPointByIsAvailable(Integer isAvailable) throws Exception {
		List<AccessPoint> accessPointList;
		try {
			accessPointList=accessPointRepository.getAllAccessPointByIsAvailable(isAvailable);
			return accessPointList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
