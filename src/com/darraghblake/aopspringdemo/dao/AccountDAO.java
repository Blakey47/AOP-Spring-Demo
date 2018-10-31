package com.darraghblake.aopspringdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.darraghblake.aopspringdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// Simulating an Exception
		if (tripWire) {
			throw new RuntimeException("Simulated Exception has occurred.");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account tempAcc1 = new Account("Jerry", 25);
		Account tempAcc2 = new Account("Susan", 48);
		Account tempAcc3 = new Account("Rachel", 111);
		
		myAccounts.add(tempAcc1);
		myAccounts.add(tempAcc2);
		myAccounts.add(tempAcc3);
		
		return myAccounts;
	}
	
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
