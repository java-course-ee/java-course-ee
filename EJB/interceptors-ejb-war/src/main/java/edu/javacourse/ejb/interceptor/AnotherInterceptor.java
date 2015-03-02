package edu.javacourse.ejb.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class AnotherInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AnotherInterceptor.class);

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        log.debug("AnotherInterceptor - start");
        Object o = ctx.proceed();
        log.debug("AnotherInterceptor - end");
        return o;
    }

}
