package edu.javacourse.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
@Aspect
public class AfterReturningAspect {

    @AfterReturning(
            pointcut = "execution(* edu.javacourse.spring.bean.RegionManager.getNumber(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        System.out.println("logAfterReturning() is running!");
        System.out.println("перехват : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");

    }

}

