/*===========================
FileName: StaffMasterService.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

/*===========================
FileName: StaffMasterService.java
Author:Tushar Mahajan
History:
Date:Jul 18, 2020:created
============================*/

package com.demo.accesscontrol.service;

import java.util.List;

import com.demo.accesscontrol.entity.StaffMaster;

/**
 * @author Tushar mahajan
 *
 */
public interface StaffMasterService {
	public List<StaffMaster> getAllStaffDetail() throws Exception;
		
	public StaffMaster getStaffById(String id) throws Exception;
	
	public StaffMaster saveStaff(StaffMaster staff) throws Exception;
}
