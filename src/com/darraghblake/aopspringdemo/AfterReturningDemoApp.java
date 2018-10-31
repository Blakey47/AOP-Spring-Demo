package com.darraghblake.aopspringdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.darraghblake.aopspringdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the Bean from the Spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts(false);
		
		// Display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp\n");
		
		System.out.println(theAccounts + "\n");
		
		// Close the context
		context.close();
		
	}

}
