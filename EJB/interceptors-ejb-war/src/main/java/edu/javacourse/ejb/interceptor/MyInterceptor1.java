package edu.javacourse.ejb.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MyInterceptor1 {

    @PostConstruct
    public void method1(InvocationContext ctx) throws Exception {
        System.out.println("method 1.1");
        ctx.proceed();
    }

    @PreDestroy
    public void method2(InvocationContext ctx) throws Exception {
        System.out.println("method 2.1");
        ctx.proceed();
    }

    @AroundInvoke
    public Object method3(InvocationContext ctx) throws Exception {
        System.out.println("method 3.1 - start");
        Object o = ctx.proceed();
        System.out.println("method 3.1 - end");
        return o;
    }
}
