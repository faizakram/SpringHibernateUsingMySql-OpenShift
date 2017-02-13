package com.Accer.Entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("request")
@Entity
@Table(name = "user_profile", catalog = "accer")
public class UserProfile implements java.io.Serializable {
 	private static final long serialVersionUID = 1L;
	private String userEmailId;
	private String name;
	private String dob;
	private String doj;
	private String mobileNo;
	private String skype;
	private String linkedIn;
	private String facebook;
	private String twitter;
	private String googlePlus;
	private String website;
	private String address;
	private String profilePic;
	private UserVerfication userVerfication;
	private Users users; 
	
	
	public UserProfile() {
	}

	public UserProfile(String userEmailId, String name, String dob, String doj, String mobileNo, String skype,
			String linkedIn, String facebook, String twitter, String googlePlus, String website, String address,
			String profilePic, UserVerfication userVerfication, Users users) {
		super();
		this.userEmailId = userEmailId;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.mobileNo = mobileNo;
		this.skype = skype;
		this.linkedIn = linkedIn;
		this.facebook = facebook;
		this.twitter = twitter;
		this.googlePlus = googlePlus;
		this.website = website;
		this.address = address;
		this.profilePic = profilePic;
		this.userVerfication = userVerfication;
		this.users = users;
	}

	@Id
	@Column(name = "User_Email_Id", unique = true, nullable = false, length = 60)
	public String getUserEmailId() {
		return this.userEmailId;
	}

	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	@Column(name = "Name", nullable = false, length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DOB", length = 20)
	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "DOJ", length = 60)
	public String getDoj() {
		return this.doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	@Column(name = "MobileNo", length = 10)
	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "Skype", length = 65535)
	public String getSkype() {
		return this.skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	@Column(name = "LinkedIn", length = 65535)
	public String getLinkedIn() {
		return this.linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	@Column(name = "Facebook", length = 65535)
	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	@Column(name = "Twitter", length = 65535)
	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Column(name = "GooglePlus", length = 65535)
	public String getGooglePlus() {
		return this.googlePlus;
	}

	public void setGooglePlus(String googlePlus) {
		this.googlePlus = googlePlus;
	}

	@Column(name = "Website", length = 65535)
	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Column(name = "Address", length = 65535)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ProfilePic", length = 65535)
	public String getProfilePic() {
		return this.profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userProfile")
	public UserVerfication getUserVerfication() {
		return userVerfication;
	}

	public void setUserVerfication(UserVerfication userVerfication) {
		this.userVerfication = userVerfication;
	}
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userProfile")
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	 

}
