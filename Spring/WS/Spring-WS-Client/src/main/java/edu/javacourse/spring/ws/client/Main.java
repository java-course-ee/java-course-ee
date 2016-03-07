package edu.javacourse.spring.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        SimpleWebServieClient client = context.getBean("client", SimpleWebServieClient.class);

        String response = client.sayHello("Vasiliy");

        log.debug("Response name: {}", response);

    }

}
