package com.darraghblake.aopspringdemo.dao;

import org.springframework.stereotype.Component;

import com.darraghblake.aopspringdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an Account.\n");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork() is called.\n");
		return false;
	}

	public String getName() {
		System.out.println(getClass() + ": getName() is called.");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName() is called.");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getServiceCode() is called.\n");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setServiceCode() is called.");
		this.serviceCode = serviceCode;
	}

}
