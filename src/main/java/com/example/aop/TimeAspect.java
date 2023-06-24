package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect  // AOP类
public class TimeAspect {
    @Pointcut("execution(* com.example.service.*.*(..))")
    public void pt(){}

    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        return result;
    }
}
