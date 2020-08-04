/*===========================
FileName: DateUtil.java
Author:Tushar Mahajan
History:
Date:Jul 22, 2020:created
============================*/

/*===========================
FileName: DateUtil.java
Author:Tushar Mahajan
History:
Date:Jul 22, 2020:created
============================*/

package com.demo.accesscontrol.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Tushar mahajan
 *
 */
public class DateUtil {

	private final static String STD_MYSQL_DB_DATE_FORMAT="yyyy-mm-dd hh:mm:ss"; 
	// date to date std date format
	public static Date changeDateFormatToStdDBSaveformat(Date date1) {

		SimpleDateFormat sdf=new SimpleDateFormat(STD_MYSQL_DB_DATE_FORMAT);
		
		try {
			return sdf.parse(sdf.format(date1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// date to custom date format date 
	public static Date changeDateFormatToStdDBSaveformat2(Date date1,String format) {

		try {
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.parse(sdf.format(date1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
