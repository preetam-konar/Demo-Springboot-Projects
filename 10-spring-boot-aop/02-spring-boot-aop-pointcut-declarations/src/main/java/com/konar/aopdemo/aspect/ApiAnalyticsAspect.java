package com.konar.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.konar.aopdemo.aspect.AopExpressions.forDaoPackageNotGetterSetter()")
    public void performAnalytics() {
        System.out.println("\n=====> Performing API analytics");
    }

}
