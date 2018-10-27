package com.darraghblake.aopspringdemo.dao;

import org.springframework.stereotype.Component;

import com.darraghblake.aopspringdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": Doing my DB work: Adding an Account.\n\n");
	}

}
