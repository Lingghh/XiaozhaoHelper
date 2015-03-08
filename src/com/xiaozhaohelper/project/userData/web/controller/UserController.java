package com.xiaozhaohelper.project.userData.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiaozhaohelper.project.userData.model.UserInformation;
import com.xiaozhaohelper.project.userData.service.UserInformationService;

@Controller

public class UserController {
	
	@Autowired
	private UserInformationService userInformationService;
	
	/**
	 *  登录
	 * @param model
	 * @param userID
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value="userID") String userID,
			@RequestParam(value="password") String password) {
		UserInformation userInformation = userInformationService.getByPK(userID);
		if(userInformation!=null && userInformation.getStatus()==userInformation.STATUS_ACTIVATE&&userInformation.getPassword().equals(password)) {
			return "redirect:/home";
		}
		else {
			if(userInformation==null ) {
				model.addAttribute("error", "用户不存在");
				return "/login";
			} 
			if(userInformation.getPassword().equals(password)) {
				model.addAttribute("error", "密码错误");
				return "/login";
			}
			if(userInformation.getStatus()==userInformation.STATUS_NOT_ACTIVATE) {
				model.addAttribute("error", "用户未激活");
				return "/login";
			} else {
				model.addAttribute("error", "该用户已被禁用，请与管理员联系");
				return "/login";
			}
			
		}
	}
	
	/**
	 * 返回用户主页
	 * @param model
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="/{userID}", method=RequestMethod.POST)
	public String getUserDetailInformation(Model model,@PathVariable("userID") String userID) {
		
		model.addAttribute("userInformation", userInformationService.getByPK(userID));
		return "/user/detail";
	}
	
	/**
	 * 异步检查用户名是否被注册
	 * @return
	 */
	public String checkUserID() {
		return null;
	}
	
	/**
	 * 异步检查邮件是否被注册
	 * @return
	 */
	public String checkEmail() {
		return null;
	}
	
	/**
	 * 保存未激活的用户
	 * @param model
	 * @param userInformation
	 * @return
	 */
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(UserInformation userInformation) {
		
		userInformation.setRegisterTime(new Date());
		userInformation.setStatus(userInformation.STATUS_NOT_ACTIVATE);
		userInformationService.save(userInformation);
		
		/*
		 * 发送邮件激活
		 */
		
		return "/wait";
		
	}
	
	/**
	 * 通过邮件激活用户
	 * @param userInformation
	 * @return
	 */
	public String updateUserStatus(UserInformation userInformation) {
		
		userInformation.setStatus(userInformation.STATUS_ACTIVATE);
		
		userInformationService.update(userInformation);
		return "/activateSuccess";
	}
	
	
	
	/**
	 * 修改密码成功后，返回用户主页
	 * @param userInformation
	 * @param password
	 * @return
	 */	@RequestMapping(value="/user/changePassword", method = RequestMethod.POST)
	public String changePassword(UserInformation userInformation, String password) {
		userInformation.setPassword(password);
		userInformationService.update(userInformation);
		
		//返回用户个人主页
		return "/{userID}";
	}
	
}
