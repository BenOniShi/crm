package com.manager.crm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Controller;

public class LoginPoint {


    @Pointcut(" execution(*com.shsxt.crm.controller..*.*(..))")
    public void cut(){};





    @Around(value = "cut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        Controller annotation = pjp.getTarget().getClass().getAnnotation(Controller.class);
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("-------------------------");

        System.out.println(annotation);
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("-------------------------");
        System.out.println("-------------------------");

        result=pjp.proceed();
        return result;
    }
}
