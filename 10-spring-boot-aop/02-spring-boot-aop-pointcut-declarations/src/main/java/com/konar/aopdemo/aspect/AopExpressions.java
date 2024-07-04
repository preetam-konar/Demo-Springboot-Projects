package com.konar.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.konar.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.konar.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("execution(* com.konar.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNotGetterSetter() {
    }

}
