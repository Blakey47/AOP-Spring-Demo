package com.darraghblake.aopspringdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.darraghblake.aopspringdemo.dao.AccountDAO;
import com.darraghblake.aopspringdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the Bean from the Spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// Call the business method
		Account myAccount = new Account("John", 22);
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// Call the accountDAO getter/setter methods
		theAccountDAO.setName("Account Name");
		theAccountDAO.setServiceCode("Gold");	
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// Call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.goTosleep();
		
		// Close the context
		context.close();
		
	}

}
