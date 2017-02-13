package com.Accer.ServiceImplemaintation;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Accer.DAOInterFace.LoginDAOInterFace;
import com.Accer.Entity.Roles;
import com.Accer.Entity.UserProfile;
import com.Accer.Entity.UserVerfication;
import com.Accer.Entity.Users;
import com.Accer.GetDateTime.GetCurrentDateTime.GetCurrentDateTime;
import com.Accer.JsonEntity.LoginJsonObject;
import com.Accer.MaillingAPI.SendMessage;
import com.Accer.ServiceInterFace.LoginServiceInterFace;

@Service
public class LoginServiceImplemaintation implements LoginServiceInterFace {

	@Autowired
	private LoginDAOInterFace loginDAOInterFace;
	@Autowired
	private GetCurrentDateTime getCurrentDateTime;
	@Autowired
	private SendMessage sendMail;
	@Autowired
	@Qualifier(value = "BCryptPasswordEncoder")
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	@Qualifier(value = "BigInteger")
	private BigInteger bigInteger;
	@Autowired
	private UserProfile userProfile;
	@Autowired
	private UserVerfication userVerification;
	@Autowired
	private Users user;
	@Autowired
	private LoginJsonObject loginJsonObject;

	/*@Autowired
	private ThreadPoolTaskExecutor taskExecutor;*/
	
	@Override
	@Transactional
	public boolean registerNewAccount(String fullName, String userEmail, String password, String repeatpassword) {
		UserProfile userProfilelocal = loginDAOInterFace.findUserProfile(userEmail);
		if (userProfilelocal != null) {
			return false;
			}
		userProfile.setName(fullName);
		userProfile.setUserEmailId(userEmail);
		userProfile.setDoj(getCurrentDateTime.getCurrentDate());
		userVerification.setUserEmailVerification(bigInteger.toString(32));
		userVerification.setAdminEmailVerification(bigInteger.toString(32));
		userVerification.setUserProfile(userProfile);
		userProfile.setUserVerfication(userVerification);
		sendMail.setUserAccessKey(userVerification.getUserEmailVerification());
		sendMail.setAdminAccessKey(userVerification.getAdminEmailVerification());
		sendMail.setName(fullName);
		sendMail.setEmailId(userEmail);
		sendMail.setPassword(password);
		sendMail.setStatus("verifyByAdmin");
		new Thread(sendMail).start();
		
		return loginDAOInterFace.updateUserProfile(userProfile);
	}
	
	@Transactional
	@Override
	public boolean addPartner(UserProfile userProfile,
			String password, String userType,boolean accountStatus){
		user.setEnable(accountStatus);
		user.setPassword(passwordEncoder.encode(password));
		Roles role = loginDAOInterFace.findUserRole(userType);
		Set<Roles> roles = new HashSet<Roles>();
		roles.add(role);
		user.setRoleses(roles);
		userProfile.setDoj(getCurrentDateTime.getCurrentDate());
		userProfile.setMobileNo(userProfile.getMobileNo());
		userProfile.setName(userProfile.getName());
		userProfile.setUserEmailId(userProfile.getUserEmailId());
		user.setUserProfile(userProfile);
		userProfile.setUsers(user);
		return loginDAOInterFace.updateUserProfile(userProfile);
	}
	
	@Override
	@Transactional
	public boolean findAccessKeyandEmailIdByAdminWithAccept(String accesskey, String fullName, String userEmail,
			String password, String userType) {
			System.out.println("accesskey" + accesskey);
			System.out.println("fullName" + fullName);
			System.out.println("userEmail" + userEmail);
			System.out.println("password" + password);
			System.out.println("userType" + userType);
			UserProfile userProfileLocal = loginDAOInterFace.findAccessKeyandEmailIdByAdmin(accesskey, userEmail);
			if(userProfileLocal != null){
			user.setUserProfile(userProfileLocal);
			user.setPassword(passwordEncoder.encode(password));
			Roles role = loginDAOInterFace.findUserRole(userType);
			Set<Roles> roles = new HashSet<Roles>();
			roles.add(role);
			user.setRoleses(roles);
			userProfileLocal.setName(fullName);
			userProfileLocal.setUserEmailId(userEmail);
			userProfileLocal.setDoj(getCurrentDateTime.getCurrentDate());
			UserVerfication userVerification = userProfileLocal.getUserVerfication();
			userVerification.setAdminEmailVerification("Verified");
			userVerification.setAccountStatus("Continue");
			if(userProfileLocal.getUserVerfication().getUserEmailVerification().equals("Verified"))
				user.setEnable(true);
			else
				user.setEnable(false);
			if(userProfileLocal.getUserVerfication().getAdminEmailVerification().equals("Verified"))
				{
				user.setEnable(true);
				}
			else
				{
					user.setEnable(false);
				}
			userVerification.setUserProfile(userProfileLocal);
			userProfileLocal.setUserVerfication(userVerification);
			userProfileLocal.setUsers(user);
			return loginDAOInterFace.updateUserProfile(userProfileLocal);
			}
		return false;
	}

	@Override
	@Transactional
	public boolean findAccessKeyandEmailIdByAdminwithRejection(String accesskey, String userEmail) {
		if(loginDAOInterFace.findAccessKeyandEmailIdByAdmin(accesskey, userEmail) != null)
		{
			return loginDAOInterFace.rejectAccountByAdmin(userEmail);
		}
		return false;
	}
	
	@Override
	@Transactional
	public boolean findAccessKeyandEmailIdByUserWithAccept(String accessKey, String emailId) {
		UserProfile userProfile = loginDAOInterFace.findAccessKeyandEmailIdByUser(accessKey, emailId);
		System.out.println(accessKey +"----------"+ emailId);
		if(userProfile != null)
		{
			userProfile = loginDAOInterFace.findUserProfile(emailId);
			userProfile.setDoj(getCurrentDateTime.getCurrentDate());
			UserVerfication userVerification = userProfile.getUserVerfication();
			if (userVerification.getAdminEmailVerification() == "Verified") {
				userProfile.getUsers().setEnable(true);
			}
			userVerification.setUserEmailVerification("Verified");
			return true;
		}
		return false;
	}
	
	
	

	@Override
	@Transactional
	public LoginJsonObject findUserByEmailIdUserTable(String userEmail) {
		
		loginJsonObject.setAvailableEmailId(loginDAOInterFace.findUserByEmailIdUserTable(userEmail));
		UserProfile userProfile = loginDAOInterFace.findUserProfile(userEmail);
		if (userProfile != null) {
			loginJsonObject
					.setAdminEmailVerificationStatus(userProfile.getUserVerfication().getAdminEmailVerification());
			loginJsonObject
					.setUserEmailVerificationStatus(userProfile.getUserVerfication().getUserEmailVerification());
			loginJsonObject.setAccountStauts(userProfile.getUserVerfication().getAccountStatus());
		}
		return loginJsonObject;
	}

	@Override
	@Transactional
	public String UpdateAccountVerifiedByUser(String emailId) {
		UserProfile userProfile = loginDAOInterFace.findUserProfile(emailId);
		userProfile.setDoj(getCurrentDateTime.getCurrentDate());
		UserVerfication userVerification = userProfile.getUserVerfication();
		if (userVerification.getAdminEmailVerification() == "Verified") {
			userVerification.setAccountStatus("Continue");
		}
		userVerification.setUserEmailVerification("Verified");
		return "Verified";
	}

	

	@Override
	@Transactional
	public boolean forgotPassword(String userEmail) {
		UserProfile userProfile = loginDAOInterFace.findUserProfile(userEmail);
		if (userProfile != null) {
			userProfile.getUserVerfication().setForgotPassword(bigInteger.toString(32));
			sendMail.setStatus("forgotPassword");
			sendMail.setName(userProfile.getName());
			sendMail.setEmailId(userProfile.getUserEmailId());
			//sendMail.setAccessKey(userProfile.getUserVerfication().getForgotPassword());
			/*sendMail.forgotPassword(userProfile.getName(), userProfile.getUserEmailId(),
					userProfile.getUserVerfications().getForgotPassword());*/
			/*taskExecutor.execute(sendMail);
			for (;;) {
				int count = taskExecutor.getActiveCount();
				System.out.println("Active Threads : " + count);
				 
				if (count != 0) {
					taskExecutor.shutdown();
					break;
				}
			}*/
			return loginDAOInterFace.updateUserProfile(userProfile);
		}
		return false;
	}

	@Override
	@Transactional
	public LoginJsonObject findPasswordAccessKeyandEmailIdByUserWithVerify(String accessKey, String emailId) {
		if(loginDAOInterFace.findPasswordAccessKeyandEmailIdByUser(accessKey, emailId))
		{
			loginJsonObject.setAccountStauts("True");
			UserProfile userProfile = loginDAOInterFace.findUserProfile(emailId);
			UserVerfication userVerification = userProfile.getUserVerfication();
			userVerification.setForgotPassword("Verified");
			loginJsonObject.setAvailableEmailId(userProfile.getUserEmailId());
			return loginJsonObject;
		}
		loginJsonObject.setAccountStauts("False");
		return loginJsonObject;
	}



	@Override
	@Transactional
	public String updatePasswordSetup(String userEmail, String password) {
		Users user = loginDAOInterFace.findUserByIdInUserTable(userEmail);
		if (user != null) {
			user.setPassword(passwordEncoder.encode(password));
			return "Success";
		} else

			return "No User Found";
	}

	@Override
	@Transactional
	public UserProfile addStudentLoginInfo(String studentName,
			String studentEmail, String password, String rolename, String dateofbirth, String contactnumber, String address) {
		UserProfile userProfilelocal = loginDAOInterFace.findUserProfile(studentEmail);
		if(userProfilelocal != null)
		{
			return userProfilelocal;
		}
		userProfile.setName(studentName);
		userProfile.setUserEmailId(studentEmail);
		userProfile.setMobileNo(contactnumber);
		userProfile.setDob(dateofbirth);
		userProfile.setAddress(address);
		userProfile.setDoj(getCurrentDateTime.getCurrentDate());
		user.setUserProfile(userProfile);
		user.setPassword(passwordEncoder.encode(password));
		Roles role = loginDAOInterFace.findUserRole(rolename);
		Set<Roles> roles = new HashSet<Roles>();
		roles.add(role);
		user.setRoleses(roles);
		user.setEnable(true);
		userProfile.setUsers(user);
		if(loginDAOInterFace.updateUserProfile(userProfile))
		{
			return userProfile;
		}
		return null;
	}
}
