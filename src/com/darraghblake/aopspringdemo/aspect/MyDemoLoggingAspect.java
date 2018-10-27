package com.darraghblake.aopspringdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// This is where we add all of our related advices for logging
	
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("LOGGING DETAILS: Executing @Before advice on addAccount().");
	}
	
}
