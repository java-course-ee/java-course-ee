package edu.javacourse.spring.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
    }

}
