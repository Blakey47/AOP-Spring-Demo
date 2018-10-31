package com.darraghblake.aopspringdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@AfterThrowing(
			pointcut="execution(* com.darraghblake.aopspringdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("-------------------------------");
		System.out.println("Executing @AfterThrowing on method: " + method + "\n");
		
		System.out.println("The Exception: " + theExc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.darraghblake.aopspringdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturnFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("-------------------------------");
		System.out.println("Executing @AfterReturn on method: " + method + "\n");
		System.out.println("Result: " + result);
		
		// Post-process the data
		convertAccountNamesToUpperCase(result);
		
		System.out.println("UpperCaseResult: " + result);
		
	}

	@Before("com.darraghblake.aopspringdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("LOGGING DETAILS: Executing @Before advice on addAccount().");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
		
	}
	
}
