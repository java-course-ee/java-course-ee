package edu.javacourse.spring.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class AfterMethod implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterMethod!");
    }

}

