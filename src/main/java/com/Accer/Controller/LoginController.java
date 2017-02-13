package com.Accer.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Accer.Captcha.Captcha;
import com.Accer.JsonEntity.LoginJsonObject;
import com.Accer.ServiceInterFace.LoginServiceInterFace;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceInterFace loginServiceInterFace;
	@Autowired
	private Captcha captcha;
	@Autowired
	AuthenticationClass auth;
	@Autowired
	private ModelAndView model;

	/* Login and After Logout Page */
	@RequestMapping(value = {"/","index","/AdminLogin"}, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		if (!auth.getAuthenticationName().getName().equals("anonymousUser")
				&& !auth.getAuthenticationType().toString().equals("[ROLE_ANONYMOUS]")) {
			model.setViewName("forward:AdminInside");
			return model;
		}
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("Login/index");
		return model;
	}
	
	
	


	/* Forgot Password Page */
	@RequestMapping(value = "/ForgotPassword", method = RequestMethod.GET)
	public ModelAndView forgotPassword() {
		model.setViewName("Login/ForgotPassword");
		return model;
	}

	/* Registration Page */
	@RequestMapping(value = "/registrationPage", method = RequestMethod.GET)
	public ModelAndView registrationPage() {
		model.setViewName("Login/RegistrationPage");
		return model;
	}

	@RequestMapping(value = "/requestForNewCompany", method = RequestMethod.GET)
	public ModelAndView requestForNewCompany() {
		model.setViewName("Login/requestForNewCompany");
		return model;
	}

	/* Lock Screen Page */
	@RequestMapping(value = "/lockScreen", method = RequestMethod.GET)
	public ModelAndView lockScreen() {
		model.setViewName("Login/LockScreen");
		return model;
	}

	/* Register New Account Request */
	@RequestMapping(value = "/registerNewAccount", method = RequestMethod.POST)
	public @ResponseBody boolean registerNewAccount(HttpServletRequest request,
			@RequestParam(value = "fullName", required = true) String fullName,
			@RequestParam(value = "userEmail", required = true) String userEmail,
			@RequestParam(value = "password", required = true) String password) {

		if (!captcha.CheckCaptcha(request)) {
			return false;
		}
		userEmail = userEmail.toLowerCase();
		return loginServiceInterFace.registerNewAccount(fullName, userEmail, password, password);
	}

	/* Account Verify Request From Admin Side */
	@RequestMapping(value = "/accountVerifiedByAdmin", method = RequestMethod.GET)
	public ModelAndView accountVerifiedByAdmin(
			@RequestParam(value = "accessKey", required = true) String accesskey,
			@RequestParam(value = "userEmail", required = true) String userEmail,
			@RequestParam(value = "action", required = true) String action,
			@RequestParam(value = "fullName", required = true) String fullName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "userType", required = true) String userType) {
			userEmail = userEmail.toLowerCase();
			
		if (loginServiceInterFace.findAccessKeyandEmailIdByAdminWithAccept(accesskey, fullName, userEmail, password,
				userType) && action.equals("Accept")) {
			model.addObject("content", "<h1>" + fullName + " Account Has Accepted</h1> ");
			model.addObject("link", "index");
			model.addObject("clickContent", "Click Here To Go Login");
			model.setViewName("Login/multiWrokingPage");
			return model;
		}
		
		else if (loginServiceInterFace.findAccessKeyandEmailIdByAdminwithRejection(accesskey, userEmail)
				&& action.equals("Reject")) {
			model.addObject("content",
					"<h1>" + fullName + " Account Has Rejected</h1><h3>This has been Rejected</h3> ");
			model.addObject("link", "index");
			model.addObject("clickContent", "Click Here To Go Login");
			model.setViewName("Login/multiWrokingPage");
			return model;
		} else {
			model.addObject("content", "<h1>Already Verified</h1><h3>You have verifed this Account.</h3> ");
			model.addObject("link", "index");
			model.addObject("clickContent", "Click Here To Go Login");
			model.setViewName("Login/multiWrokingPage");
			return model;
		}
	}

	/* Account Verify Request From User Side */
	@RequestMapping(value = "/accountVerifiedByUser", method = RequestMethod.GET)
	public ModelAndView accountVerifiedByUser(@RequestParam(value = "email", required = true) String emailId,
			@RequestParam(value = "accessKey", required = true) String accessKey) {

		emailId = emailId.toLowerCase();
		if (loginServiceInterFace.findAccessKeyandEmailIdByUserWithAccept(accessKey, emailId)) {
			model.addObject("content",
					"<h1>Account Verified From User Side</h1><h3>Wait form Admin Side Verification</h3> ");
			model.addObject("link", "index");
			model.addObject("clickContent", "Click Here To Go Login");
			model.setViewName("Login/multiWrokingPage");
			return model;
		} else {
			model.addObject("content", "<h1>No User Found</h1><h3>Try Again to Create Account</h3> ");
			model.addObject("link", "registrationPage");
			model.addObject("clickContent", "Click Here To Create Account");
			model.setViewName("Login/multiWrokingPage");
			return model;
		}

	}

	@RequestMapping(value = "/CheckUser", method = RequestMethod.POST)
	public @ResponseBody LoginJsonObject checkUser(@RequestParam(value = "UserId") String userEmail) {
		userEmail = userEmail.toLowerCase();
		LoginJsonObject loginObject = loginServiceInterFace.findUserByEmailIdUserTable(userEmail);
		return loginObject;
	}

	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public @ResponseBody boolean forgotPassword(@RequestParam(value = "UserEmail", required = true) String userEmail) {
		userEmail = userEmail.toLowerCase();
		return loginServiceInterFace.forgotPassword(userEmail);
	}

	@RequestMapping(value = "/passwordRest", method = RequestMethod.GET)
	public ModelAndView passwordRest(@RequestParam(value = "email", required = true) String emailId,
			@RequestParam(value = "accessKey", required = true) String accessKey) {

		emailId = emailId.toLowerCase();
		LoginJsonObject json = loginServiceInterFace.findPasswordAccessKeyandEmailIdByUserWithVerify(accessKey, emailId);
		if (json.getAccountStauts().equals("True")) {
			model.addObject("emailId", json.getAvailableEmailId());
			model.setViewName("Login/restPassword");
			return model;
		} else {
			model.addObject("content",
					"<h1>Seession Expried</h1><h3>Try Again To Reset Your Password. Next Time Don't Refresh the Page.</h3> ");
			model.addObject("link", "ForgotPassword");
			model.addObject("clickContent", "Click Here To Rest Your password");
			model.setViewName("Login/multiWrokingPage");
			return model;
		}
	}

	@RequestMapping(value = "/Updatepassword", method = RequestMethod.POST)
	public @ResponseBody String updatePasswordSetup(@RequestParam(value = "UserEmail", required = true) String userEmail,
			@RequestParam(value = "newPassword", required = true) String password) {
		userEmail = userEmail.toLowerCase();
		return loginServiceInterFace.updatePasswordSetup(userEmail, password);
	}

}
