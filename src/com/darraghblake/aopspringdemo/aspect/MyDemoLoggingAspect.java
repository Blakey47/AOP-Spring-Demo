package com.darraghblake.aopspringdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.darraghblake.aopspringdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.darraghblake.aopspringdemo.service.*.getFortune(..))")
	public Object aroundLoggingAspect(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		printMethodName(theProceedingJoinPoint, "@Around");
		
		long begin = System.currentTimeMillis();
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			
			throw e;
		}
		
		long end = System.currentTimeMillis();
		long duration = end - begin;
		
		myLogger.info("Duration: " + duration / 1000.0 + " seconds.");
		
		return result;
	}
	
	@After("execution(* com.darraghblake.aopspringdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		printMethodName(theJoinPoint, "@After");
	}
	
	@AfterThrowing(
			pointcut="execution(* com.darraghblake.aopspringdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		printMethodName(theJoinPoint, "@AfterThrowing");
		
		myLogger.info("The Exception: " + theExc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.darraghblake.aopspringdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturnFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		printMethodName(theJoinPoint, "@AfterReturning");
		myLogger.info("Result: " + result);
		
		// Post-process the data
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("UpperCaseResult: " + result);
		
	}

	@Before("com.darraghblake.aopspringdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("LOGGING DETAILS: Executing @Before advice on addAccount().");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				myLogger.info("Account name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());
			}
		}
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}
	
	private void printMethodName(JoinPoint theJoinPoint, String adviceType) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("-------------------------------");
		myLogger.info("\nExecuting " + adviceType + " on method: " + method + "\n");
	}
	
}
