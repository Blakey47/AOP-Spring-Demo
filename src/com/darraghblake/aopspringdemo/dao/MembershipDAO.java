package com.darraghblake.aopspringdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING STUFF: ADDING MEMBERSHIP ACCOUNT.\n\n");
	}
	
	public boolean goTosleep() {
		System.out.println(getClass() + ": I'M NEVER GOING TO SLEEP.\n\n");
		return false;
	}
	
}
