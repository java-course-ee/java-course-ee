package edu.javacourse.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Artem Pronchakov
 */

@Stateless
@LocalBean
public class SimpleEJB {

    private static final Logger log = LoggerFactory.getLogger(SimpleEJB.class);

    @Resource
    private ManagedExecutorService managedExecutorService;

    public void testMethod() {

        Runnable my = new MyRunnable();

        managedExecutorService.execute(my);
        managedExecutorService.execute(my);
        managedExecutorService.execute(my);
        managedExecutorService.execute(my);
        managedExecutorService.execute(my);

    }

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("Runnable: hello");
        }
    }

}
