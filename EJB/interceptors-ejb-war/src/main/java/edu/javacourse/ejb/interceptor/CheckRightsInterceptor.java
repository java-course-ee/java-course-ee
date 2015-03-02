package edu.javacourse.ejb.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class CheckRightsInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CheckRightsInterceptor.class);

    @AroundInvoke
    public Object invoke(InvocationContext ctx) throws Exception {
        log.debug("CheckRightsInterceptor - start");
        Object o = ctx.proceed();
        log.debug("CheckRightsInterceptor - end");
        return o;
    }

}
