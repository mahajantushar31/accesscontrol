/*===========================
FileName: LoginController.java
Author:Tushar Mahajan
History:
Date:Jul 17, 2020:created
============================*/

/**
 * 
 */
package com.demo.accesscontrol.controller.login;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accesscontrol.common.util.AccessCtrlConstant;
import com.demo.accesscontrol.common.util.CommonUtil;
import com.demo.accesscontrol.common.util.ConfigProperties;
import com.demo.accesscontrol.common.util.QRGenerationUtil;
import com.demo.accesscontrol.dto.ResponseDto;
import com.demo.accesscontrol.dto.UserDto;
import com.demo.accesscontrol.entity.User;
import com.demo.accesscontrol.entity.UserAccess;
import com.demo.accesscontrol.entity.UserQrAccess;
import com.demo.accesscontrol.service.EmailService;
import com.demo.accesscontrol.service.UserAccessService;
import com.demo.accesscontrol.service.UserQrAccessService;
import com.demo.accesscontrol.service.UserService;

/**
 * @author Tushar mahajan
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	
	
	//STAFf  new:	email	Role Password	firstname	lastname	dob	phone	date_of_joining	last_active_date	
	
	//	ACCESSMASTER:- 	User,    QR(AccCode),role_id, access_creation_date,access_valid_date
	
		@Autowired
		UserService userService;
		
		@Autowired
		EmailService emailService;
		
		@Autowired
		UserAccessService userAccessService;
		
		@Autowired
		UserQrAccessService userQrAccessService;
		
		ResponseDto responseDto=new ResponseDto();
		
		
	/*
	 * ModelMapper modelMapper = new ModelMapper(); // user here is a prepopulated
	 * User instance UserDTO userDTO = modelMapper.map(user, UserDTO.class);
	 */
		
		Map<String,String> emailCofigParam=new HashMap<String,String>();
		ConfigProperties config=new ConfigProperties();
	
	  String emailSubject=config.getEmailSubject(); //"ACCESS CONTROL SUBJ email";
	  String emailContent=config.getEmailContent();
	  //"AccessControl  email content"; 
	  String emailFrom=config.getEmailFrom(); // "tushar.mahajan@beutosys.com"; 
	  String authEmail=config.getAuthEmail(); 
	  String authEmailPass=config.getAuthEmailPass(); 
	  String receivingEmail=config.getReceivingEmail();
	  
	  String mimeMsgContent=config.getMimeMsgContent(); String
	  attachement=config.getAttachement(); String customEmailContent="";
	 
		

		
// ADMIN REGISTERING 
	  
		@PostMapping("/adminRegister")
		public ResponseEntity<User>  getAdminRegister(@Valid  @RequestBody UserDto userAdmin){
			User user = new User("admin");
			UserAccess userAccess=new UserAccess();
			UserQrAccess userQrAccess=new UserQrAccess();
			String respoMsg="";
			
			try {
				user=(User) CommonUtil.objectUtilMapper(userAdmin, user);
				String password=(null!=user.getPassword() && !user.getPassword().trim().isEmpty())?user.getPassword():"admin";
				user.setPassword(password);
				user = userService.saveOrUpdate(user);

				if(null!=user) {
					   responseDto=userAccessCreationForUserCreated(user);				
				}else {
					respoMsg=" User Registering returned Null response  ";
					responseDto.setResponseMsg(respoMsg);
					responseDto.setResponseObject(user);
				}
				
				return new ResponseEntity(responseDto,HttpStatus.OK);
			} catch (Exception e) {
				
				respoMsg="Error While registering User : "+e.fillInStackTrace();
				responseDto.setResponseMsg(respoMsg);
				responseDto.setResponseObject(user);
			}
			return new ResponseEntity(user,HttpStatus.NO_CONTENT);
		}
		

// EMP REGISTER
		
		@PostMapping("/empRegister")
		public ResponseEntity<User>  getEmpRegister(@Valid  @RequestBody UserDto userAdmin){
			User user = new User("emp");
			UserAccess userAccess=new UserAccess();
			UserQrAccess userQrAccess=new UserQrAccess();
			String respoMsg="";
			
			try {
				user=(User) CommonUtil.objectUtilMapper(userAdmin, user);
				String password=(null!=user.getPassword() && !user.getPassword().trim().isEmpty())?user.getPassword():"emp";
				user.setPassword(password);
				user = userService.saveOrUpdate(user);

				if(null!=user) {
					   responseDto=userAccessCreationForUserCreated(user);				
				}else {
					respoMsg=" User Registering returned Null response  ";
					responseDto.setResponseMsg(respoMsg);
					responseDto.setResponseObject(user);
				}
				
				return new ResponseEntity(responseDto,HttpStatus.OK);
			} catch (Exception e) {
				
				respoMsg="Error While registering User : "+e.fillInStackTrace();
				responseDto.setResponseMsg(respoMsg);
				responseDto.setResponseObject(user);
			}
			return new ResponseEntity(user,HttpStatus.NO_CONTENT);
		}
	
		
// VISITOR  REGISTER
		
				@PostMapping("/visitorRegister")
				public ResponseEntity<User>  getVisitorRegister(@Valid  @RequestBody UserDto userAdmin){
					User user = new User("visitor");
					UserAccess userAccess=new UserAccess();
					UserQrAccess userQrAccess=new UserQrAccess();
					String respoMsg="";
					
					try {
						user=(User) CommonUtil.objectUtilMapper(userAdmin, user);
						String password=(null!=user.getPassword() && !user.getPassword().trim().isEmpty())?user.getPassword():"visitor";
						user.setPassword(password);
						user = userService.saveOrUpdate(user);

						if(null!=user) {
							   responseDto=userAccessCreationForUserCreated(user);				
						}else {
							respoMsg=" User Registering returned Null response  ";
							responseDto.setResponseMsg(respoMsg);
							responseDto.setResponseObject(user);
						}
						
						return new ResponseEntity(responseDto,HttpStatus.OK);
					} catch (Exception e) {
						
						respoMsg="Error While registering User : "+e.fillInStackTrace();
						responseDto.setResponseMsg(respoMsg);
						responseDto.setResponseObject(user);
					}
					return new ResponseEntity(user,HttpStatus.NO_CONTENT);
				}		
		

		
//---------------------------------------------- -----------------------------------------------------------------------		
		private ResponseDto userAccessCreationForUserCreated(User user) {
			UserAccess userAccess;
			UserQrAccess userQrAccess;
			String respoMsg="";
			ResponseDto responseDto=new ResponseDto();
			try {	
				// access_Table Entry
				userAccess=setUserAccessRecordAndSave(user);
				if(null!=userAccess) {
					
					userQrAccess=generateQrForAccessUserAndSave(userAccess);
					if(null!=userQrAccess) {
					/*
					 * System.out.println("\n\n EMAIL LOADED CONFIG ARE "+config+
					 * " \n  emailFrom:"+emailFrom+" authEmail:"+config.getAuthEmail()
					 * +" authEmailPass:"+config.getAuthEmailPass());
					 * System.out.println("  mimeMsgContent:"+mimeMsgContent+" attachement:"
					 * +attachement);
					 */
						emailCofigParam.put("emailSubject"," Invite User d for Access Control");
						// -----------------------------------------	
						emailCofigParam.put(AccessCtrlConstant.EMAIL_FROM,config.getEmailFrom());
						emailCofigParam.put(AccessCtrlConstant.AUTH_EMAIL,config.getAuthEmail());
						emailCofigParam.put(AccessCtrlConstant.AUTH_MAIL_PASS,config.getAuthEmailPass());
						emailCofigParam.put(AccessCtrlConstant.RECEIVE_EMAIL,user.getEmail());
						customEmailContent="<p> hi "+user.getFirstname()+" u have got access AccessControl App User Qr Id code is"
								+ " "+userQrAccess.getQr()+" </p>";
						emailCofigParam.put(AccessCtrlConstant.EMAIL_CONTENT,customEmailContent);
						// ------------------------------------------------
						emailCofigParam.put(AccessCtrlConstant.ATTACHEMENT,attachement);
						emailCofigParam.put(AccessCtrlConstant.MIME_MSG_CONTENT,mimeMsgContent);
						
						respoMsg=emailService.sendInviteMail(emailCofigParam);
						System.out.println("\n\nLOADED CONFIG FROM MAP  ----> : "+emailCofigParam);
						responseDto.setResponseMsg(respoMsg);
						responseDto.setResponseObject(user);
					}else {
						respoMsg="User QR Access creation return with null response ";
						responseDto.setResponseMsg(respoMsg);
						responseDto.setResponseObject(userQrAccess);
					}
				}else {
					respoMsg="UserAccess creation return with null response ";
					responseDto.setResponseMsg(respoMsg);
					responseDto.setResponseObject(userAccess);
				}
			
			}catch(Exception e) {
				
				respoMsg=" UserAccess creation interpted  Error "+e.fillInStackTrace();;
				responseDto.setResponseMsg(respoMsg);
				responseDto.setResponseObject(user);
			}
			return responseDto;
		}
		
		
		
		private String getAccessCode(String roleCode){
			Map<String,String> accessCodemap=new HashMap();
			accessCodemap.put("admin", "1234"); // 1 mainGate 2 OPD 3 ICU1 4 Emergency 
			accessCodemap.put("emp", "124");
			accessCodemap.put("visitor", "14");
			return (null==accessCodemap.get(roleCode))?"1":accessCodemap.get(roleCode);
		}
			
		private UserQrAccess generateQrForAccessUserAndSave(UserAccess userAccess) {
			UserQrAccess userQrAccess=new UserQrAccess();
			userQrAccess.setAccess_id(userAccess.getAccess_id());
			Map<String,String> paramMap=new HashMap();
			paramMap.put(userAccess.getRole_id(),userAccess.getAccess_code());
			String qr=QRGenerationUtil.generateQR(paramMap);
			userQrAccess.setQr(qr);
			try {
				userQrAccess=userQrAccessService.saveOrUpdate(userQrAccess);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			return userQrAccess;
		}
		
		
		private UserAccess setUserAccessRecordAndSave(User user){
			// access_name[Fk]	access_code[FK]	role_id [Fk]	access_creation_date	access_valid_date

			
			UserAccess userAccess=new UserAccess();
			userAccess.setAccess_name(user.getEmail());
			userAccess.setAccess_code(getAccessCode(user.getRole_id()));
			userAccess.setRole_id(user.getRole_id());
			userAccess.setAccessCreationDate(new Date());
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));

			Date lastDayOfMonth = cal.getTime();
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY-mm-dd");
			Date dt=null;
			try {
				dt = new SimpleDateFormat("YYYY-mm-dd").parse(sdf.format(lastDayOfMonth));
				userAccess.setAccessValidDate(dt);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			try {
				userAccess=userAccessService.saveOrUpdate(userAccess);
				if(null!=userAccess)
					System.out.println("  "+userAccess.toString());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			return userAccess;
		}
		
		
		
		
		
		
		@PostMapping("/registerUser")
		public ResponseEntity<User>  getStaffById(@Valid  @RequestBody String id){
			User user = null;
			try {
				user = userService.getUserById(id);
				return new ResponseEntity(user,HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity(user,HttpStatus.NO_CONTENT);
		}
		
		@RequestMapping("/saveUser")
		public ResponseEntity<User> saveUser(@RequestBody UserDto userDto){
			// firstname lastname dob email phone date_of_joining last_active_date
			System.out.println(" -->  "+userDto.toString());
			User user= (User) CommonUtil.objectUtilMapper(userDto, new User());
			// ModelMapper m=new ModelMapper();
			try {
				user = userService.saveOrUpdate(user);
				return new ResponseEntity(user,HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  new ResponseEntity(user,HttpStatus.NO_CONTENT);
			
		}
		
		@RequestMapping("/sendInviteEmail")
		public ResponseEntity<String> sendInviteEmail(){   // @RequestBody StaffMasterDto staff
			// firstname lastname dob email phone date_of_joining last_active_date
			// System.out.println(" sysout "+staff.toString());
			// StaffMaster staffMst= (StaffMaster) CommonUtil.objectUtilMapper(staff, new StaffMaster());
			// ModelMapper m=new ModelMapper();
			String emailMsg="";
			Map<String,String> emailConfigParam=new HashMap<String,String>();
			try {
				emailMsg = emailService.sendInviteMail(emailConfigParam);
				return new ResponseEntity(emailMsg,HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  new ResponseEntity(emailMsg,HttpStatus.NO_CONTENT);
			
		}

		
		@GetMapping("/getAllUserDetail")
		public ResponseEntity<List<User>> getAllStaffDetail()  {
			List<User> userList = null;
			try {
				userList = userService.getAllUserDetail();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity(userList,HttpStatus.OK);
			
		}
		

		
		
}
