package com.xiaozhaohelper.project.companyData.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozhaohelper.project.base.dao.BaseDao;
import com.xiaozhaohelper.project.base.service.impl.BaseServiceImpl;
import com.xiaozhaohelper.project.companyData.dao.CompanyInformationDao;
import com.xiaozhaohelper.project.companyData.model.CompanyInformation;
import com.xiaozhaohelper.project.companyData.service.CompanyInformationService;

@Service
@org.springframework.transaction.annotation.Transactional
public class CompanyInformationServiceImpl extends BaseServiceImpl<CompanyInformation, String> implements CompanyInformationService{

	private CompanyInformationDao companyInformationDao;
	
	@Autowired
	@Override
	public void setBaseDao(BaseDao<CompanyInformation, String> baseDao) {
		// TODO Auto-generated method stub
		this.baseDao = baseDao;
		this.companyInformationDao = (CompanyInformationDao) baseDao;
		
	}

}
