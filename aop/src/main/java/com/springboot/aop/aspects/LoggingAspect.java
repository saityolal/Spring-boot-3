package com.springboot.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(getClass());


    //execution (* PACKAGE.*.*(..))
    @Before("execution(* com.springboot.aop.*.*(..))")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before  Method {} is called with arguments {}", joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.springboot.aop.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Method {} is called with arguments {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(
            pointcut = "execution(* com.springboot.aop.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.error("An error occurred while calling method {} with arguments {}: {}", joinPoint, joinPoint.getArgs(), exception.getMessage());
    }

    @AfterReturning(
            pointcut = "execution(* com.springboot.aop.*.*(..))",
            returning = "result"
    )
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method {} returned with result: {}", joinPoint, result);
    }
}
