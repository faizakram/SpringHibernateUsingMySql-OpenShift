package com.Accer.Captcha;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
@Component
@Scope("request")
public class Captcha {
	
	@Autowired
	@Qualifier(value ="reCaptcha")
	ReCaptchaImpl reCaptcha;
	
	public boolean CheckCaptcha(HttpServletRequest request)
	{
		String remoteAddr = request.getRemoteAddr();
        //reCaptcha.setPrivateKey("6LfsqygTAAAAAGaUUQ_0G9V6wWXqX5wKsYZvBQpu"); //For Local Host
        reCaptcha.setPrivateKey("6Lc-tSgTAAAAAONIeUFk9CEAJN1gbenU-PGOEBTL");
        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
        if (reCaptchaResponse.isValid()) {
        	System.out.println("Valid");
        	return true;
        } else {
        	return false;
        }
		
	}
}
