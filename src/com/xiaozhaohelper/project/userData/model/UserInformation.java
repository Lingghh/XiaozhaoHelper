package com.xiaozhaohelper.project.userData.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name="T_UserInformation")
@Entity
public class UserInformation implements Serializable{
	
	public final static int STATUS_NOT_ACTIVATE = 0;
	public final static int STATUS_ACTIVATE = 1;
	public final static int STATUS_FORBIDDEN = 2;
	
	@Id
	@Column(name="PK_User_ID", nullable=false, unique=true,length=30)
	private String userID;
	
	@Column(name="Email", nullable=false, unique = true)
	private String email;
	
	@Column(name="Password", nullable = false,length=255)
	private String password;
	
	@Column(name="Name", nullable = false, length=20)
	private String name;
	
	@Column(name="School",length = 50)
	private String school;
	
	@Column(name="Major", length= 50)
	private String major;
	
	@Column(name="FinishYear",length=10)
	private String finisherYear;
	
	@Column(name="Resume")
	private String resume;
	
	@Column(name="Wechat_ID")
	private String wechatID;
	
	@Column(name="RegisterTime", nullable=false)
	private Date registerTime;
	
	@Column(name="LastLoginTime", nullable = false)
	private Date lastLoginTime;
	
	@Column(name="Status", nullable=false)
	private int status;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getFinisherYear() {
		return finisherYear;
	}

	public void setFinisherYear(String finisherYear) {
		this.finisherYear = finisherYear;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getWechatID() {
		return wechatID;
	}

	public void setWechatID(String wechatID) {
		this.wechatID = wechatID;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
