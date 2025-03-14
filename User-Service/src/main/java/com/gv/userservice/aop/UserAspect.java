package com.gv.userservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;

@Aspect
@Component
public class UserAspect {

    @Before(value = "execution(* com.gv.userservice.controller.UserController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + LocalDateTime.now());
    }

    @After(value = "execution(* com.gv.userservice.controller.UserController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + LocalDateTime.now());
    }

    @Around(value = "execution(* com.gv.userservice.controller.UserController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startMills = Instant.now().toEpochMilli();
        long executionTime = 0;
        try {
            Object proceedObj = proceedingJoinPoint.proceed();
            executionTime = Instant.now().toEpochMilli() - startMills;
            return proceedObj;
        } catch (Exception e) {
            return null;
        } finally {
            System.out.println(proceedingJoinPoint.getSignature() + " executed in : " + executionTime + "ms");
        }
    }
}
