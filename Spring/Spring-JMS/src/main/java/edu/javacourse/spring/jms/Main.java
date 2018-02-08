package edu.javacourse.spring.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        Thread.sleep(5000);

        JmsTemplate jmsTemplate = context.getBean("jmsTemplate", JmsTemplate.class);
        for (int i = 0; i < 10; i++) {
            jmsTemplate.convertAndSend("test-queue", "test message: " + i);
        }
    }

}
