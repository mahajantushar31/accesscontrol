package com.demo.accesscontrol.common.util;

import java.lang.reflect.Field;
/**
 * @author Tushar mahajan
 *
 */
public class CommonUtil {

	public static Object objectUtilMapper(Object object1,Object object2) {
		
		 Class cls1=object1.getClass();
		 Field fields1[]=cls1.getDeclaredFields();
		 Field f=null;
		 // -- 
		 Class cls2=object2.getClass();
		 Field fields2[]=cls2.getFields();
		 Field f2=null;
		 System.out.println(" object 2 length : "+fields2.length);
		 
		 if (fields1.length > 0) {
		 
			 for (int i=0; i<fields1.length; i++) {
				 try {
					  f=fields1[i];							// first object fileds
					 Field s=cls2.getDeclaredField(f.getName());	// get value of field 
					 f.setAccessible(true);
					  f2=cls2.getDeclaredField(f.getName());
					 f2.setAccessible(true);
					 f2.set(object2, f.get(object1));
					 //System.out.println("  - Fields-  "+f.get(object1)+" -- "+cls2.getDeclaredField(f.getName()));
				 }catch(Exception e) {
					 System.out.println(" Exception "+e.getStackTrace()+"objec1 "+f.getName()+" Of Type :"+f.getType()+" objec 2 "+f2.getName()+" of Type :"+f2.getType() ); 
				 }
			 }
		 }else {
			 System.out.println(" NO MAtch while object maping Object 1 : "+fields1.length);
		 }
		 
		 		
		return object2;
	}
	
	
	// map object Except null or blank from Object1 
	public static Object objectUtilMapperExceptnNullOrBlank(Object object1,Object object2) {
		
		 Class cls1=object1.getClass();
		 Field fields1[]=cls1.getDeclaredFields();
		 Field f=null;
		 // -- 
		 Class cls2=object2.getClass();
		 Field fields2[]=cls2.getFields();
		 Field f2=null;
		 
		 System.out.println(" object 2 length : "+fields2.length);
		 
		 if (fields1.length > 0) {
		 
			 for (int i=0; i<fields1.length; i++) {
				 try {
					  f=fields1[i];							// first object fileds
					 Field s=cls2.getDeclaredField(f.getName());	// get value of field 
					 f.setAccessible(true);
					  f2=cls2.getDeclaredField(f.getName());
					  // if (f1.getType().equals(f2.getType()))
					 if(null!=f.get(object1) && !((String) f.get(object1)).trim().isEmpty() && !((String) f.get(object1)).trim().isBlank()) {
						 f2.setAccessible(true);
						 f2.set(object2, f.get(object1));
					 }
					 //System.out.println("  - Fields-  "+f.get(object1)+" -- "+cls2.getDeclaredField(f.getName()));
				 }catch(Exception e) {
					 System.out.println(" Exception "+e.getStackTrace()+"objec1 "+f.getName()+" Of Type :"+f.getType()+" objec 2 "+f2.getName()+" of Type :"+f2.getType() ); 
				 }
			 }
		 }else {
			 System.out.println(" NO MAtch while object maping Object 1 : "+fields1.length);
		 }
		 
		 		
		return object2;
	}
	
	// 1 .map only field which both have common   
	// 2 .object 1 having null values wont mapped to object2
	public static Object objectUtilMapperOnlyCommonFieldsExcludeNull(Object object1,Object object2) {
		
		 Class cls1=object1.getClass();
		 Field fields1[]=cls1.getDeclaredFields();
		 
		 // -- 
		 Class cls2=object2.getClass();
		 Field fields2[]=cls2.getFields();
		 
		// System.out.println(" object 2 length : "+fields2.length);
		 
		 if (fields1.length > 0) {
		 
			 for (int i=0; i<fields1.length; i++) {
				 try {
					 Field f=fields1[i];							// first object fileds
					 Field s=cls2.getDeclaredField(f.getName());	// get value of field 
					 f.setAccessible(true);
					 Field f2=null;
					 try {
					  f2=cls2.getDeclaredField(f.getName());
					 }catch(Exception e) {
						 System.out.println(" first Object has "+f.getName()+" not matching with object field ");
						 continue;
					 }
					 
					 if(null!=f.get(object1) && !((String) f.get(object1)).trim().isEmpty() && !((String) f.get(object1)).trim().isBlank()) {
						 f2.setAccessible(true);
						 f2.set(object2, f.get(object1));
					 }
					 //System.out.println("  - Fields-  "+f.get(object1)+" -- "+cls2.getDeclaredField(f.getName()));
				 }catch(Exception e) {
					 System.out.println(" Exception "+e.getStackTrace()); 
				 }
			 }
		 }else {
			 System.out.println(" NO MAtch while object maping Object 1 : "+fields1.length);
		 }
		 
		 		
		return object2;
	}
	
}
