package edu.javacourse.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.ThrowsAdvice;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
@Aspect
public class AfterThrowAspect implements ThrowsAdvice {

    @AfterThrowing(
            pointcut = "execution(* edu.javacourse.spring.bean.RegionManager.createRegion(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("logAfterThrowing() is running!");
        System.out.println("перехват : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");

    }

}
