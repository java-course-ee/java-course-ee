package edu.javacourse.ejb;

import edu.javacourse.ejb.interceptor.AnotherInterceptor;
import edu.javacourse.ejb.interceptor.CheckRightsInterceptor;
import edu.javacourse.ejb.interceptor.LoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;

@Stateless
@LocalBean
@Interceptors({AnotherInterceptor.class})
public class InterceptorEJB {

    private static final Logger log = LoggerFactory.getLogger(InterceptorEJB.class);

    @Interceptors({CheckRightsInterceptor.class})
    @ExcludeClassInterceptors
    public void hello() {
        log.debug("*** Inside Hello method");
    }

    @Interceptors({LoggingInterceptor.class})
    public void goodbye() {
        log.debug("*** Inside Goodbye method");
    }

}
