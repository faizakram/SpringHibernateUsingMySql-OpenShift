package com.Accer.DAOInterFace;

import com.Accer.Entity.Roles;
import com.Accer.Entity.UserProfile;
import com.Accer.Entity.UserVerfication;
import com.Accer.Entity.Users;

public interface LoginDAOInterFace {

	public UserProfile findUserProfile(String userEmail);

	public boolean updateUserProfile(UserProfile userProfile);

	public Roles findUserRole(String userType);

	public boolean registerNewAccount(Users user);

	public UserProfile findAccessKeyandEmailIdByUser(String accessKey, String emailId);

	public UserProfile findAccessKeyandEmailIdByAdmin(String accesskey, String userEmail);

	public String findUserByEmailIdUserTable(String userEmail);

	public boolean rejectAccountByAdmin(String userEmail);

	public boolean findPasswordAccessKeyandEmailIdByUser(String accessKey, String emailId);

	public Users findUserByIdInUserTable(String userEmail);

	public boolean updateUserVerification(UserVerfication userVerification);

}
