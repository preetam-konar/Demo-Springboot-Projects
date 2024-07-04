package com.konar.aopdemo.aspect;

import com.konar.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    @Around("execution(* com.konar.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>Executing @Around advice for: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
//            result = "Major accident! Relief on the way.";
            throw exc;
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("Duration : " + duration / 1000);

        return result;
    }

    @After("execution(* com.konar.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>Executing @After (finally) advice for: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.konar.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>Executing @AfterThrowing advice for: " + method);
        System.out.println("\n=====>The exception is: " + exc);
    }

    @Before("com.konar.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>Executing @Before advice for addAccount");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method : " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;
                System.out.println("Name : " + account.getName());
                System.out.println("Level : " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.konar.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>Executing @AfterReturning advice for findAccounts");

        System.out.println("\n=====>Result is : " + result);

        //Modify the data before returning
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account tempAccount : result) {
            tempAccount.setName(tempAccount.getName().toUpperCase());
        }

    }

}
