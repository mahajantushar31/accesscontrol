/*===========================
FileName: StaffMasterServiceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/*===========================
FileName: StaffMasterServiceImpl.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.accesscontrol.entity.StaffMaster;
import com.demo.accesscontrol.repository.StaffMasterRepository;
import com.demo.accesscontrol.service.StaffMasterService;

/**
 * @author Tushar mahajan
 *
 */
@Service("staffMasterService")
public class StaffMasterServiceImpl implements StaffMasterService{

	@Autowired
	StaffMasterRepository staffMasterRepository; 
	
	@Override
	public List<StaffMaster> getAllStaffDetail() {
		try {
			List staffList = staffMasterRepository.getAllStaffDetail();
			
			return staffList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StaffMaster getStaffById(String id)   {
		StaffMaster staffMaster;
		try {
			staffMaster=staffMasterRepository.getStaffById(id);
			return staffMaster;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public StaffMaster saveStaff(StaffMaster staff)  {
		StaffMaster staffMaster;
		try {
			staffMaster=staffMasterRepository.save(staff);
			return staffMaster;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
