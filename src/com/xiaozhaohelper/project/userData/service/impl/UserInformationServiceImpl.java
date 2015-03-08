package com.xiaozhaohelper.project.userData.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaozhaohelper.project.base.dao.BaseDao;
import com.xiaozhaohelper.project.base.service.impl.BaseServiceImpl;
import com.xiaozhaohelper.project.userData.dao.UserInformationDao;
import com.xiaozhaohelper.project.userData.model.UserInformation;
import com.xiaozhaohelper.project.userData.service.UserInformationService;

@Service
@Transactional
public class UserInformationServiceImpl extends BaseServiceImpl<UserInformation, String> implements UserInformationService{

	private UserInformationDao userInformationDao;
	
	@Autowired
	@Override
	public void setBaseDao(BaseDao<UserInformation, String> baseDao) {
		// TODO Auto-generated method stub
		this.baseDao = baseDao;
		this.userInformationDao = (UserInformationDao) baseDao;
	}

}
