package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TableAspect {
    @Before("execution(* *(..)) && @annotation(Table)")
    public void before(JoinPoint joinPoint){
        System.out.println("---------TABLE SAMPLE OF VALUES---------");
        System.out.println("----------------------------------------");
    }

    @After("execution(* *(..)) && @annotation(Table)")
    public void after(JoinPoint joinPoint){
        System.out.println("----------------------------------------");
    }
}
