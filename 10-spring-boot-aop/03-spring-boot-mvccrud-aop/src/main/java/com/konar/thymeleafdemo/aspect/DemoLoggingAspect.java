package com.konar.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.konar.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.konar.thymeleafdemo.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.konar.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=====>in @Before: calling method: " + method);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            myLogger.info("=====>argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("=====>in @AfterReturning: calling method: " + method);
        myLogger.info("=====>Result: " + result);
    }

}
