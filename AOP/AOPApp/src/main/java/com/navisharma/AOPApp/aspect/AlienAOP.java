package com.navisharma.AOPApp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
@Aspect
@Component
public class AlienAOP {

    public AlienAOP() {
        System.out.println("========== AlienAOP CREATED ==========");
    }

    @Before("execution(* com.navisharma.AOPApp.rest.AlienController.*(..))")   //Advice
    public void beforeAdvice(JoinPoint joinPoint) {

        System.out.println("========== BEFORE ADVICE ==========");

        System.out.println(
                "Request Made to " +
                        joinPoint.getSignature() +
                        " at " +
                        LocalTime.now()
        );
    }



    @Before("execution(* com.navisharma.AOPApp.service.AlienService.*(..))")
    public void beforeAdviceService(JoinPoint joinPoint) {

        System.out.println("========== BEFORE ADVICE ==========");

        System.out.println(
                "Request Made to " +
                        joinPoint.getSignature() +
                        " at " +
                        LocalTime.now()
        );
    }



    @After("execution(* com.navisharma.AOPApp.rest.AlienController.*(..))")
    public void AfterAdvice(JoinPoint joinPoint) {

        System.out.println("========== AFTER ADVICE ==========");

        System.out.println(
                "Request Made to " +
                        joinPoint.getSignature() +
                        " at " +
                        LocalTime.now()
        );
    }



    @After("execution(* com.navisharma.AOPApp.service.AlienService.*(..))")
    public void AfterAdviceService(JoinPoint joinPoint) {

        System.out.println("========== AFTER ADVICE ==========");

        System.out.println(
                "Request Made to " +
                        joinPoint.getSignature() +
                        " at " +
                        LocalTime.now()
        );
    }
}