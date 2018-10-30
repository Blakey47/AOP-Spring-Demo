package com.darraghblake.aopspringdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.darraghblake.aopspringdemo.dao.*.*(..))")
	public void forDaoPackage() {}
		
	@Pointcut("execution(* com.darraghblake.aopspringdemo.dao.*.get*(..))")
	public void getter() {}
		
	@Pointcut("execution(* com.darraghblake.aopspringdemo.dao.*.set*(..))")
	public void setter() {}
		
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}

}
