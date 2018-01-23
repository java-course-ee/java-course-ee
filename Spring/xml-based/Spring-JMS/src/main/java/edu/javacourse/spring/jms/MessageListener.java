package edu.javacourse.spring.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.Message;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    @JmsListener(destination = "test-queue")
    public void processJMSMessage(Message message) {
        log.info("Message received: {}", message);
    }

}
