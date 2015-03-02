package edu.javacourse.ejb.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        log.debug("LoggingInterceptor - start");
        Object o = ctx.proceed();
        log.debug("LoggingInterceptor - end");
        return o;
    }

}
