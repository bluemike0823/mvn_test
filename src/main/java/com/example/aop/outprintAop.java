package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
public class outprintAop {
    
    private static final Logger logger 
        = LoggerFactory.getLogger(outprintAop.class);

    @Before("execution(* com.example.Controller..*(..))")
    public void beforeOutPrint(JoinPoint joinPoint){

        logger.info("beforeOutPrint() --> ");
        logger.info("getName() -->" + joinPoint.getSignature().getName());
        System.out.println("Before recoding...");
        System.out.println("====================================");

    }

}
