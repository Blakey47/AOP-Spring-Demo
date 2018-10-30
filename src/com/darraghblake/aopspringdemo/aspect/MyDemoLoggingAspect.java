package com.darraghblake.aopspringdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// This is where we add all of our related advices for logging
	
	@Pointcut("execution(* com.darraghblake.aopspringdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("LOGGING DETAILS: Executing @Before advice on addAccount().");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("PERFORMING ANALYTICS.");
	}
	
}
