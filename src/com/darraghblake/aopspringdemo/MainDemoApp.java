package com.darraghblake.aopspringdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.darraghblake.aopspringdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// Read Spring Config Java Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the Bean from the Spring container
		AccountDAO theAccount = context.getBean("accountDAO", AccountDAO.class);
		
		// Call the business method
		theAccount.addAccount();
		
		// Close the context
		context.close();
		
	}

}
