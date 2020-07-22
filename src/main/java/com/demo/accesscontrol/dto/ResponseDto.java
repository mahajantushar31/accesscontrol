/*===========================
FileName: ResponseDto.java
Author:Tushar Mahajan
History:
Date:Jul 22, 2020:created
============================*/

/*===========================
FileName: ResponseDto.java
Author:Tushar Mahajan
History:
Date:Jul 22, 2020:created
============================*/

package com.demo.accesscontrol.dto;

import java.io.Serializable;

/**
 * @author Tushar mahajan
 *
 */
public class ResponseDto implements Serializable {

	String responseMsg;
	Object responseObject;
	Integer responseCode;
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public Object getResponseObject() {
		return responseObject;
	}
	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	
	
}
