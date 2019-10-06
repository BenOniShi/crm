package com.shsxt.crm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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
