package com.Accer.DAOInterFace;

import com.Accer.Entity.UserProfile;

public interface DashboardDAOInterFace {

	public UserProfile findUserProfileByUserEmail(String name);
	public String updateUserProfile(UserProfile userProfileLocal);

}
