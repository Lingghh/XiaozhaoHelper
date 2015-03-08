package com.xiaozhaohelper.project.userData.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozhaohelper.project.userData.model.UserInformation;

@Controller
public class HomeController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
				
		if (request.getSession().getAttribute("userID") == null )
			return "/login";
		else
			return "/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		request.getSession().invalidate();
		return "/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request) {
		return "/register";
	}
	
	@RequestMapping(value = "/registerSuccess", method = RequestMethod.GET)
	public String registerSuccess(HttpServletRequest request) {
		return "/registerSuccess";
	}
	
	@RequestMapping(value = "/forgetPwd", method = RequestMethod.GET)
	public String forgetPwd(HttpServletRequest request) {
		return "/forgetPwd";
	}
	
	@RequestMapping(value = "/activationSuccess", method = RequestMethod.GET)
	public String activationSuccess(HttpServletRequest request) {
		return "/activationSuccess";
	}
	
	@RequestMapping(value = "/newPassword", method = RequestMethod.GET)
	public String newPassword(HttpServletRequest request) {
		return "/newPassword";
	}
	
	@RequestMapping(value = "/newPasswordSuccess", method = RequestMethod.GET)
	public String newPasswordSuccess(HttpServletRequest request) {
		return "/newPasswordSuccess";
	}

	
}
