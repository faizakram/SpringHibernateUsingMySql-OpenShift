package com.Accer.Controller;

import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
@Component
@Scope("request")
public class AuthenticationClass {

	public Authentication getAuthenticationName() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return auth;
	}

	// Get Authentication Type (Like Login User Type)
	public Collection<? extends GrantedAuthority> getAuthenticationType() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		Collection<? extends GrantedAuthority> value = auth.getAuthorities();		
		return value;
	}
}
