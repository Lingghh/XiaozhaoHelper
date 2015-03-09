package com.xiaozhaohelper.project.companyData.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_CompanyInformation")
public class CompanyInformation implements Serializable{
	
	@Id
	@GenericGenerator(name="generator", strategy="uuid.hex")
	@GeneratedValue(generator = "generator")
	@Column(name="PK_Company_ID", nullable=false, unique=true)
	public String companyID;
	
	@Column(name="CompanyName",nullable=false)
	public String companyName;
	
	@Column(name="CompanyIntroduce")
	public String companyIntroduce;

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyIntroduce() {
		return companyIntroduce;
	}

	public void setCompanyIntroduce(String companyIntroduce) {
		this.companyIntroduce = companyIntroduce;
	}
	
}
