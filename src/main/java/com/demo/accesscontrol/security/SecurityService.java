/*===========================
FileName: SecurityService.java
Author:Tushar Mahajan
History:
Date:Jul 17, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.security;

/**
 * @author Tushar mahajan
 *
 */
public interface SecurityService {
	String findLoggedInUsername();

    void autoLogin(String username, String password);
}
