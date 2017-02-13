package com.Accer.JsonEntity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class LoginJsonObject {
	private String availableEmailId;
	private String userEmailVerificationStatus;
	private String adminEmailVerificationStatus;
	private String accountStauts;
	private Set<String> tollfree = new HashSet<String>();
	
	public Set<String> getTollfree() {
		return tollfree;
	}
	public void setTollfree(Set<String> tollfree) {
		this.tollfree = tollfree;
	}
	public String getAvailableEmailId() {
		return availableEmailId;
	}
	public void setAvailableEmailId(String availableEmailId) {
		this.availableEmailId = availableEmailId;
	}
	public String getUserEmailVerificationStatus() {
		return userEmailVerificationStatus;
	}
	public void setUserEmailVerificationStatus(String userEmailVerificationStatus) {
		this.userEmailVerificationStatus = userEmailVerificationStatus;
	}
	public String getAdminEmailVerificationStatus() {
		return adminEmailVerificationStatus;
	}
	public void setAdminEmailVerificationStatus(String adminEmailVerificationStatus) {
		this.adminEmailVerificationStatus = adminEmailVerificationStatus;
	}
	public String getAccountStauts() {
		return accountStauts;
	}
	public void setAccountStauts(String accountStauts) {
		this.accountStauts = accountStauts;
	}
	
}
