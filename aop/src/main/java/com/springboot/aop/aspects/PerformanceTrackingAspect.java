package com.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around("execution(* com.springboot.aop.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
     long start = System.currentTimeMillis();
     Object returnValue = proceedingJoinPoint.proceed();
     long end = System.currentTimeMillis();
     long executionTime = end - start;
     logger.info("Method {} execution time: {} ms",proceedingJoinPoint, executionTime);

     return returnValue;
    }
}
