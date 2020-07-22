/*===========================
FileName: QRGenerationUtil.java
Author:Tushar Mahajan
History:
Date:Jul 21, 2020:created
============================*/

/*===========================
FileName: QRGenerationUtil.java
Author:Tushar Mahajan
History:
Date:Jul 21, 2020:created
============================*/

package com.demo.accesscontrol.common.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tushar mahajan
 *
 */
public class QRGenerationUtil {

	private static final Logger logger=LoggerFactory.getLogger(QRGenerationUtil.class); 
	public static String generateQR(Map<String,String> paramMap) {
		String qr="1";
		
		if(!paramMap.isEmpty() && null!= paramMap.get("admin"))
			return "1234";
		if(!paramMap.isEmpty() && null!= paramMap.get("emp"))
			return "14";
		if(!paramMap.isEmpty() && null!= paramMap.get("visitor"))
			return "1";
		return qr;
	}
	
}
