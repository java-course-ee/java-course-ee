package edu.javacourse.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ContextService;
import javax.enterprise.concurrent.ManagedThreadFactory;

/**
 * @author Artem Pronchakov
 */

@Stateless
@LocalBean
public class SimpleEJB {

    private static final Logger log = LoggerFactory.getLogger(SimpleEJB.class);

    @Resource
    private ManagedThreadFactory managedThreadFactory;

    public void testMethod() {

        Thread thread = managedThreadFactory.newThread(new MyRunnable());
        thread.start();

    }

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                log.debug("Runnable: hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
