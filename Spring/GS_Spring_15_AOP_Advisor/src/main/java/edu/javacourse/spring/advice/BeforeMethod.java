package edu.javacourse.spring.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class BeforeMethod implements MethodBeforeAdvice {


    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before Method!");
    }

}

