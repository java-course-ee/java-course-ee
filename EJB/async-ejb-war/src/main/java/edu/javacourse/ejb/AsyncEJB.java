package edu.javacourse.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class AsyncEJB {

    private static final Logger log = LoggerFactory.getLogger(AsyncEJB.class);

    @PostConstruct
    public void init() {
        log.info("AsyncEJB created");
    }

    @PreDestroy
    public void destroy() {
        log.info("AsyncEJB destroyed");
    }
    
    @Asynchronous
    public Future<String> sayHello() {
        try {
            log.debug("Start sayHello method");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                log.debug("Still sleeping");
            }
        } catch (InterruptedException ex) {
        }
        log.debug("Return result");
        return new AsyncResult<String>("përshëndetje");
    }

    
}
