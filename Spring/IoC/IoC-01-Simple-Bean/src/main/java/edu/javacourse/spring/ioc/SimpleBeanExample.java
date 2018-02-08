package edu.javacourse.spring.ioc;

import edu.javacourse.spring.ioc.beans.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class SimpleBeanExample {

    private static Logger log = LoggerFactory.getLogger(SimpleBeanExample.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});

        log.debug("\n\n\n");

        final Car car = context.getBean("car", Car.class);
        log.debug("Car model: {}", car.getModel());
    }

}
