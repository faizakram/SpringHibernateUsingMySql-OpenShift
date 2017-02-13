package com.Accer.ServiceInterFace;

import com.Accer.Entity.UserProfile;
import com.Accer.JsonEntity.LoginJsonObject;

public interface LoginServiceInterFace {
	public boolean registerNewAccount(String fullName, String userEmail, String password, String repeatpassword);
	public String UpdateAccountVerifiedByUser(String emailId);
	public LoginJsonObject findUserByEmailIdUserTable(String userEmail);
	public boolean forgotPassword(String userEmail);
	public LoginJsonObject findPasswordAccessKeyandEmailIdByUserWithVerify(String accessKey, String emailId);
	public String updatePasswordSetup(String userEmail, String password);
	public boolean findAccessKeyandEmailIdByAdminWithAccept(String accesskey, String fullName, String userEmail,
			String password, String userType);
	public boolean findAccessKeyandEmailIdByAdminwithRejection(String accesskey, String userEmail);
	public boolean findAccessKeyandEmailIdByUserWithAccept(String accessKey, String emailId);
	public boolean addPartner(UserProfile userProfile, String password, String userType,boolean accountStatus);
	public UserProfile addStudentLoginInfo(String studentName,
			String studentEmail, String password, String string, String dateofbirth, String contactnumber, String address);

}
