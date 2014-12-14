package edu.javacourse.spring.ioc;

import edu.javacourse.spring.ioc.beans.Child;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class InheritanceExample {

    private static Logger log = LoggerFactory.getLogger(InheritanceExample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        log.debug("\n\n\n");

        final Child child = context.getBean("child", Child.class);
        log.debug("Child name: {}", child.getName());
        log.debug("Child responsible's Passport Number: {}", child.getResponsible().getPaspNum());
    }

}
