package com.demo.accesscontrol.commons.util;

import java.lang.reflect.Field;
/**
 * @author Tushar mahajan
 *
 */
public class CommonUtil {

	public static Object objectUtilMapper(Object object1,Object object2) {
		
		 Class cls1=object1.getClass();
		 Field fields1[]=cls1.getDeclaredFields();
		 
		 // -- 
		 Class cls2=object2.getClass();
		 Field fields2[]=cls2.getFields();
		 
		 System.out.println(" object 2 length : "+fields2.length);
		 
		 if (fields1.length > 0) {
		 
			 for (int i=0; i<fields1.length; i++) {
				 try {
					 Field f=fields1[i];
					 Field s=cls2.getDeclaredField(f.getName());
					 f.setAccessible(true);
					 Field f2=cls2.getDeclaredField(f.getName());
					 f2.setAccessible(true);
					 f2.set(object2, f.get(object1));
					 //System.out.println("  - Fields-  "+f.get(object1)+" -- "+cls2.getDeclaredField(f.getName()));
				 }catch(Exception e) {
					 System.out.println(" Exception "+e.getStackTrace()); 
				 }
			 }
		 }else {
			 System.out.println(" Object 1 : "+fields1.length);
		 }
		 
		 		
		return object2;
	}
	
}
