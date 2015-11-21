package edu.javacourse.activemq.writetoqueue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class ActiveMQQueueReader {

    private static final Logger log = LoggerFactory.getLogger(ActiveMQQueueReader.class);

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        QueueConnection queueConnection = connectionFactory.createQueueConnection();

        QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = queueSession.createQueue("test-queue");

        MessageConsumer consumer = queueSession.createConsumer(queue);

        queueConnection.start();

        while(true) {
            log.info("Waiting for message...");
            TextMessage message = (TextMessage) consumer.receive();
            log.info("Message received with text: {} at time {}", message.getText(), System.currentTimeMillis());
        }
    }

}
