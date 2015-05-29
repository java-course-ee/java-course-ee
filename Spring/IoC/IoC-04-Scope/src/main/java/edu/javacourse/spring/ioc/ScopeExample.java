package edu.javacourse.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class ScopeExample {

    private static Logger log = LoggerFactory.getLogger(ScopeExample.class);

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        log.debug("\n\n\n");

        Date noChangingDate = context.getBean("no-changing-date", Date.class);
        log.debug("Not Changing Date: hash: {}, date: {}", noChangingDate.hashCode(), noChangingDate);

        Thread.sleep(1000);

        noChangingDate = context.getBean("no-changing-date", Date.class);
        log.debug("Not Cganging Date: hash: {}, date: {}", noChangingDate.hashCode(), noChangingDate);

        Thread.sleep(1000);

        noChangingDate = context.getBean("no-changing-date", Date.class);
        log.debug("Not Cganging Date: hash: {}, date: {}", noChangingDate.hashCode(), noChangingDate);

        log.debug("");
        log.debug("=============================================================");
        log.debug("");

        Date changingDate = context.getBean("changing-date", Date.class);
        log.debug("Changing Date: hash: {}, date: {}", changingDate.hashCode(), changingDate);

        Thread.sleep(1000);

        changingDate = context.getBean("changing-date", Date.class);
        log.debug("Changing Date: hash: {}, date: {}", changingDate.hashCode(), changingDate);

        Thread.sleep(1000);

        changingDate = context.getBean("changing-date", Date.class);
        log.debug("Changing Date: hash: {}, date: {}", changingDate.hashCode(), changingDate);
    }

}
