package com.Accer.ServiceInterFace;

import org.springframework.web.multipart.MultipartFile;

import com.Accer.Entity.UserProfile;

public interface DashboardServiceInterFace {

	public UserProfile findUserProfileByUserEmail(String name);
	public String updateProfile(String email, String name, String mobileNo, String facebookLink, String linkedInLink, String googleLink, String twitterLink, String skypeId, String websiteURL, String address, MultipartFile file);

}
