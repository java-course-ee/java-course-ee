package edu.javacourse.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
@Aspect
public class BeforeAspect {


    /*В скобочках аннотации указывается pointcut(срез), с помощью которого определяется метод который будет перехвачен методом logBefore().*/

    @Before("execution(* edu.javacourse.spring.bean.RegionManager.createRegion(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("logBefore() is running!");
        System.out.println("перехват : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

}

