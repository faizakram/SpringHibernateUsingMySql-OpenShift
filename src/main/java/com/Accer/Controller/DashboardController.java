package com.Accer.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Accer.ServiceInterFace.DashboardServiceInterFace;

@Controller
public class DashboardController {

	@Autowired
	private AuthenticationClass auth;
	@Autowired
	private DashboardServiceInterFace dashboardServiceInterFace;
	@Autowired
	private ModelAndView model;
	private int BUFFER_LENGTH = 4096;

	@RequestMapping(value = "/AdminInside", method = RequestMethod.GET)
	public ModelAndView dashboardLogin() {
			model.addObject("UserProfile",
					dashboardServiceInterFace.findUserProfileByUserEmail(auth.getAuthenticationName().getName()));
		if (auth.getAuthenticationType().toString().contains("ROLE_Admin")) {
			model.addObject("role", "Role Admin");
			model.setViewName("Admin/index");
		} else if (auth.getAuthenticationType().toString().contains("ROLE_SubAdmin")) {
			model.addObject("role", "Role Sub Admin");
			model.setViewName("Sub-Admin/index");
		} else if (auth.getAuthenticationType().toString().contains("ROLE_User")) {
			model.addObject("role", "Role User");
			model.setViewName("User/index");
		} else if (auth.getAuthenticationType().toString().contains("ROLE_SubUser")) {
			model.addObject("role", "Role Sub User");
			model.setViewName("Sub-User/index");
		}
		return model;
	}

	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView userProfile() {
		model.addObject("UserProfile",
				dashboardServiceInterFace.findUserProfileByUserEmail(auth.getAuthenticationName().getName()));
		if (auth.getAuthenticationType().toString().contains("ROLE_Admin")) {
			model.addObject("role", "Role Admin");
			model.setViewName("Admin/profile");
		} else if (auth.getAuthenticationType().toString().contains("ROLE_SubAdmin")) {
			model.addObject("role", "Role Sub Admin");
			model.setViewName("Sub-Admin/profile");
		} else if (auth.getAuthenticationType().toString().contains("ROLE_User")) {
			model.addObject("role", "Role User");
			model.setViewName("User/profile");
		} else if (auth.getAuthenticationType().toString().contains("ROLE_SubUser")) {
			model.addObject("role", "Role Sub User");
			model.setViewName("Sub-User/profile");
		}
		return model;
	}
	
	@RequestMapping(value = "/UploadProfileDetials", method = RequestMethod.POST)
	public @ResponseBody String UploadProfileDetials(@RequestParam(value="userName", required=true) String userName, 
			@RequestParam(value="userMobile", required=true)String userMobile,
			@RequestParam(value = "FacebookLink", required = false)String FacebookLink,
			@RequestParam(value = "LinkedInLink", required = false)String LinkedInLink,
			@RequestParam(value = "GoogleLink", required = false)String GoogleLink,
			@RequestParam(value ="TwitterLink", required = false)String TwitterLink,
			@RequestParam(value="SkypeId", required = false)String SkypeId,
			@RequestParam(value = "WebsiteURL", required = false)String WebsiteURL, 
			@RequestParam(value = "Address", required = false)String Address,
			@RequestParam("file") MultipartFile file) {
		return dashboardServiceInterFace.updateProfile(auth.getAuthenticationName().getName(),
				userName, userMobile,FacebookLink,LinkedInLink,GoogleLink,TwitterLink,SkypeId,WebsiteURL,Address,file);
	}

	
	
	@RequestMapping(value = "/profilePic/*", method = RequestMethod.GET)
	public void showProfileImage(HttpServletRequest request, HttpServletResponse response) {
		try {
			String filePath = request.getRequestURI();
			File file = new File("D:/apptest/Profile/" + auth.getAuthenticationName().getName() + "/" + File.separator
					+ filePath.replace("apptest/profilePic/", "")); //For Windows
			InputStream input = new FileInputStream(file);
			response.setContentLength((int) file.length());
			response.setContentType(new MimetypesFileTypeMap().getContentType(file));
			OutputStream output = response.getOutputStream();
			byte[] bytes = new byte[BUFFER_LENGTH];
			int read = 0;
			while ((read = input.read(bytes, 0, BUFFER_LENGTH)) != -1) {
				output.write(bytes, 0, read);
				output.flush();
			}
			input.close();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
