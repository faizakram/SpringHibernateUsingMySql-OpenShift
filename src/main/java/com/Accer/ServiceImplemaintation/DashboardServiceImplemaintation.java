package com.Accer.ServiceImplemaintation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.Accer.DAOInterFace.DashboardDAOInterFace;
import com.Accer.Entity.UserProfile;
import com.Accer.FileUploading.FileUploadingInWindows;
import com.Accer.ServiceInterFace.DashboardServiceInterFace;

@Service
public class DashboardServiceImplemaintation implements DashboardServiceInterFace {

	@Autowired
	private DashboardDAOInterFace dashboardDAOInterFace;
	@Autowired
	private FileUploadingInWindows fileUploading; // Its for Windows file System

	/*
	 * @Autowired private FileUploadingInOpenShift fileUploading;
	 */// Its for OpenShift file System
	@Override
	@Transactional
	public UserProfile findUserProfileByUserEmail(String name) {
		return dashboardDAOInterFace.findUserProfileByUserEmail(name);
	}

	@Override
	@Transactional
	public String updateProfile(String email, String name, String mobileNumber, String facebookLink, String linkedInLink,
			String googleLink, String twitterLink, String skypeId, String websiteURL, String address,
			MultipartFile file) {
		mobileNumber = mobileNumber.trim();
		mobileNumber = mobileNumber.replace("(", "");
		mobileNumber = mobileNumber.replace(")", "");
		mobileNumber = mobileNumber.replace("-", "");
		mobileNumber = mobileNumber.replace(" ", "");
		UserProfile userProfileLocal = dashboardDAOInterFace.findUserProfileByUserEmail(email);
		userProfileLocal.setMobileNo(mobileNumber);
		userProfileLocal.setAddress(address);
		userProfileLocal.setFacebook(facebookLink);
		userProfileLocal.setGooglePlus(googleLink);
		userProfileLocal.setLinkedIn(linkedInLink);
		userProfileLocal.setSkype(skypeId);
		userProfileLocal.setWebsite(websiteURL);
		userProfileLocal.setTwitter(twitterLink);
		userProfileLocal.setName(name);
		if (!file.equals(null) || !file.isEmpty() || file != null)
			userProfileLocal.setProfilePic(fileUploading.uploadUserProfileImage(file, email));
		return dashboardDAOInterFace.updateUserProfile(userProfileLocal);
	}

}
