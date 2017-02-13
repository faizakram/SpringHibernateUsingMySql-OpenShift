package com.Accer.Entity;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Entity
@Table(name = "user_verfication", catalog = "accer")
public class UserVerfication implements java.io.Serializable {

	 
	private static final long serialVersionUID = 1L;
	private Integer verificationId;
	private UserProfile userProfile;
	private String adminEmailVerification;
	private String userEmailVerification;
	private String mobileVerification;
	private String forgotPassword;
	private String accountStatus;

	public UserVerfication() {
	}

	public UserVerfication(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public UserVerfication(UserProfile userProfile,
			String adminEmailVerification, String userEmailVerification,
			String mobileVerification, String forgotPassword,
			String accountStatus) {
		this.userProfile = userProfile;
		this.adminEmailVerification = adminEmailVerification;
		this.userEmailVerification = userEmailVerification;
		this.mobileVerification = mobileVerification;
		this.forgotPassword = forgotPassword;
		this.accountStatus = accountStatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Verification_Id", unique = true, nullable = false)
	public Integer getVerificationId() {
		return this.verificationId;
	}

	public void setVerificationId(Integer verificationId) {
		this.verificationId = verificationId;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "User_Email_Id", nullable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "Admin_Email_Verification", length = 65535)
	public String getAdminEmailVerification() {
		return this.adminEmailVerification;
	}

	public void setAdminEmailVerification(String adminEmailVerification) {
		this.adminEmailVerification = adminEmailVerification;
	}

	@Column(name = "User_Email_Verification", length = 65535)
	public String getUserEmailVerification() {
		return this.userEmailVerification;
	}

	public void setUserEmailVerification(String userEmailVerification) {
		this.userEmailVerification = userEmailVerification;
	}

	@Column(name = "Mobile_Verification", length = 10)
	public String getMobileVerification() {
		return this.mobileVerification;
	}

	public void setMobileVerification(String mobileVerification) {
		this.mobileVerification = mobileVerification;
	}

	@Column(name = "Forgot_Password", length = 65535)
	public String getForgotPassword() {
		return this.forgotPassword;
	}

	public void setForgotPassword(String forgotPassword) {
		this.forgotPassword = forgotPassword;
	}

	@Column(name = "Account_Status", length = 20)
	public String getAccountStatus() {
		return this.accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}


}
