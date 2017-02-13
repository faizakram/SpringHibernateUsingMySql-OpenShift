package com.Accer.MaillingAPI;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
public class SendMessage implements Runnable{
	
	@Autowired
	private HTTPBasicAuthFilter httpBasicAuthFilter;
	@Autowired
	private MultivaluedMapImpl multiValuedMapImpl;
	
	private String name;
	private String emailId;
	private String password;
	private String adminAccessKey;
	private String userAccessKey;
	private String status;
	
	 
	

	public String getAdminAccessKey() {
		return adminAccessKey;
	}

	public void setAdminAccessKey(String adminAccessKey) {
		this.adminAccessKey = adminAccessKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserAccessKey() {
		return userAccessKey;
	}

	public void setUserAccessKey(String userAccessKey) {
		this.userAccessKey = userAccessKey;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private final String adminEmailId="surajmba.mba@gmail.com";

	private boolean verifyByAdmin(String name, String emailId, String password, String accessKey) {
		String content = "<body style=\"background:#4CAF40\"><div style=\"text-align:center; padding: 9px 16px; text-align: center;font-size: 16px;\">"
				+ "<h1>Registration Verification</h1><p style=\"font-size:20px;\"> "
				+ "Select User Type </p><form action=\"http://dev.cybotech.in//accountVerifiedByAdmin\" method=\"GET\" target=\"_blank\">"
				+ "<h2>Name</h2> <input type=\"text\" name=\"fullName\" value="+name+" required=\"required\" "
				+ "style=\"background-color: #4CAF50; color: white; padding: 9px 16px; "
				+ "text-align: center; text-decoration: none; display: inline-block; font-size: 16px; "
				+ "margin: 4px 2px; cursor: pointer; -webkit-transition-duration: 0.4s;"
				+ " transition-duration: 0.4s;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);\""
				+ "/><h2>Email Id</h2> <input type=\"text\" value="+emailId+" name=\"userEmail\" required=\"required\" "
				+ "style=\"background-color: #4CAF50; color: white; padding: 9px 16px; "
				+ "text-align: center; text-decoration: none; display: inline-block;"
				+ " font-size: 16px; margin: 4px 2px; cursor: pointer; -webkit-transition-duration: 0.4s; "
				+ "transition-duration: 0.4s;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 "
				+ "rgba(0,0,0,0.19);\"/><h2>Password</h2> <input type=\"text\" value="+password+" required=\"required\" "
				+ "name=\"password\" style=\"background-color: #4CAF50; color: white; "
				+ "padding: 9px 16px; text-align: center; text-decoration: none; display: "
				+ "inline-block; font-size: 16px; margin: 4px 2px; cursor:"
				+ " pointer; -webkit-transition-duration: 0.4s; transition-duration: 0.4s;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24)"
				+ ",0 17px 50px 0 rgba(0,0,0,0.19);\"/><h2>User Type "
				+ "</h2><label style=\"font-size:20px;\">User_Admin<label>"
				+ "<input type=\"radio\" name=\"userType\" required=\"required\" "
				+ "value=\"ROLE_Admin\" style=\"background-color: #4CAF50; "
				+ "color: white; padding: 9px 16px; text-align: center; "
				+ "text-decoration: none; display: inline-block; font-size: 16px;"
				+ " margin: 4px 2px; cursor: pointer; -webkit-transition-duration: 0.4s; "
				+ "transition-duration: 0.4s;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);"
				+ "\"/>"
				+ "<br><label style=\"font-size:20px;\">ROLE_Partner<label>"
				+ "<input type=\"radio\" name=\"userType\" required=\"required\" "
				+ "value=\"ROLE_Partner\" style=\"background-color: #4CAF50; "
				+ "color: white; padding: 9px 16px; text-align: center; "
				+ "text-decoration: none; display: inline-block; font-size: 16px;"
				+ " margin: 4px 2px; cursor: pointer; -webkit-transition-duration: 0.4s; "
				+ "transition-duration: 0.4s;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);"
				+ "\"/><br><label style=\"font-size:20px;\">ROLE_Instructor<label>"
				+ "<input type=\"radio\" name=\"userType\" required=\"required\" "
				+ "value=\"ROLE_Instructor\" style=\"background-color: #4CAF50; "
				+ "color: white; padding: 9px 16px; text-align: center; "
				+ "text-decoration: none; display: inline-block; font-size: 16px;"
				+ " margin: 4px 2px; cursor: pointer; -webkit-transition-duration: 0.4s; "
				+ "transition-duration: 0.4s;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);"
				+ "\"/>"
				+ "<label style=\"font-size:20px;\"><br>ROLE_Student<label><input type=\"radio\" "
				+ "name=\"userType\" required=\"required\" value=\"ROLE_Student\""
				+ " style=\"background-color: #4CAF50; color: white; padding: 9px 16px; "
				+ "text-align: center; text-decoration: none; display: inline-block; font-size: 16px;"
				+ " margin: 4px 2px; cursor: pointer; -webkit-transition-duration: 0.4s;"
				+ " transition-duration: 0.4s;box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24)"
				+ ",0 17px 50px 0 rgba(0,0,0,0.19);\"/><input type=\"hidden\" name=\"accessKey\" value="+accessKey+">"
				+ "<br><button type=\"submit\" name=\"action\" value=\"Accept\" style=\"background-color: #4CAF50;"
				+ " color: white; padding: 9px 16px; text-align: center; text-decoration: none;"
				+ " display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer; "
				+ "-webkit-transition-duration: 0.4s; transition-duration: 0.4s;box-shadow: 0 12px 16px 0 "
				+ "rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);\">Click To Accept Account</button>"
				+ "<button type=\"submit\" name=\"action\" value=\"Reject\" style=\"background-color: #4CAF50; "
				+ "color: white; padding: 9px 16px; text-align: center; text-decoration: none;"
				+ " display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer;"
				+ " -webkit-transition-duration: 0.4s; transition-duration: 0.4s;box-shadow: 0 12px 16px"
				+ " 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);\">Click To Reject Account</button>"
				+ "</form></div></body>";
		return allSendMail(adminEmailId, content,"Added New Account");
	}

	/*Email Verifiaction Mail*/
	private boolean verifyByUser(String name, String emailId, String accessKey) {
		String content="<body bgcolor=\"#DCC6E0\"><div style=\"text-align:center; padding: 9px 16px;  "
				+ "text-align: center;font-size: 16px;\"><h1>Registration Verification</h1><h3>Hello, "+name+"</h3>"
				+ "<p>Wait For Admin Side To Verify</p><a href=\"http://dev.cybotech.in//accountVerifiedByUser?email="+emailId+"&accessKey="+accessKey+"\" target=\"_blank\" style=\"background-color: #4CAF50;"
				+ " border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;"
				+ "display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;\">"
				+ "Click To Verify</a></div></body>";
		return allSendMail(adminEmailId, content, "Email Verification");
	}
	
	private boolean forgotPassword(String name, String userEmailId,
			String accessKey) {
		String content="<body bgcolor=\"#DCC6E0\"><div style=\"text-align:center; padding: 9px 16px;  "
				+ "text-align: center;font-size: 16px;\"><h1>Reset Password</h1><h3>Hello, "+name+"</h3>"
				+ "<p>Recently a request was submitted to reset your password for our members area. "
				+ "If you did not request this, please ignore this email. "
				+ "It will expire and become useless in 2 hours time.</p>"
				+ "<a href=\"http://dev.cybotech.in//passwordRest?email="+userEmailId+"&accessKey="+accessKey+"\" target=\"_blank\" style=\"background-color: #4CAF50;"
				+ " border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;"
				+ "display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;\">"
				+ "Click To Reset Your Password</a></div></body>";
		return allSendMail(userEmailId, content, "Password Reset For CRM");
	}
	
	private boolean  allSendMail(String emailId,String content, String subject){
		Client client = Client.create();
        client.addFilter(httpBasicAuthFilter);
        WebResource webResource = client.resource("https://api.mailgun.net/v2/" + "www.faizakram.com" +  "/messages");
        multiValuedMapImpl.clear();
        multiValuedMapImpl.add("from", "info@haameeem.com");
        multiValuedMapImpl.add("to", emailId);
        multiValuedMapImpl.add("subject", subject);
        multiValuedMapImpl.add("html", content);
        ClientResponse clientResponse = webResource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, multiValuedMapImpl);
        String output = clientResponse.getEntity(String.class);
        if(output.contains("Thank you"))
        	return true;
        else
        	return false;
	}

	@Override
	public void run() {
		if(status.equals("verifyByAdmin"))
		{	
			verifyByAdmin(name, emailId, password, adminAccessKey);
			multiValuedMapImpl.clear();
			verifyByUser(name, emailId, userAccessKey);
		}
		
		else if(status.equals("forgotPassword"))
		{
			forgotPassword(name, emailId, userAccessKey);
		}
		
	}

	
	
}
