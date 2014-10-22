package edu.javacourse.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
@Aspect
public class AfterAspect {

    @After("execution(* edu.javacourse.spring.bean.RegionManager.createRegion(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("logAfter() is running!");
        System.out.println("перехват : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }

}

