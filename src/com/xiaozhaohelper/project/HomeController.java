package com.xiaozhaohelper.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		return "/index";
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
	
	@RequestMapping(value="/updateInformation", method = RequestMethod.GET)
	public String changeInformation(HttpServletRequest request) {
		return "/setting";
	}

}
