package edu.javacourse.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * Author: Georgy Gobozov
 * Date: 18.07.13
 */
public class AroundMethod implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("Method name : " + methodInvocation.getMethod().getName());
        System.out.println("Method arguments : " + Arrays.toString(methodInvocation.getArguments()));

        // до метода
        System.out.println("AroundMethod : Вместо BeforeMethod!");

        try {
            // выполняем оригинальный метод
            Object result = methodInvocation.proceed();
            // после метода
            System.out.println("AroundMethod : Вместо AfterMethod!");
            return result;
        } catch (IllegalArgumentException e) {
            // если был выброс исключения
            System.out.println("AroundMethod : Вместо ThrowMethod!");
            throw e;
        }

    }
}
