package com.darraghblake.aopspringdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

	@Before("forDaoPackageNoGetterSetter()")
	public void loggingToCloud() {
		System.out.println("LOGGING DATA TO CLOUD IN ASYNC FASHION.");
	}
	
}
