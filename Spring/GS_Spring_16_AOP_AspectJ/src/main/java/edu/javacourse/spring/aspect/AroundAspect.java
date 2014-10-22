package edu.javacourse.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
@Aspect
public class AroundAspect {

    @Around("execution(* edu.javacourse.spring.bean.RegionManager.createRegion(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("logAround() is running!");
        System.out.println("перехваченный метод : " + joinPoint.getSignature().getName());
        System.out.println("перехваченные аргументы : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed();
        System.out.println("Around after is running!");

        System.out.println("******");

    }
}
