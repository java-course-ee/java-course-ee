package edu.javacourse.activemq.writetoqueue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class ActiveMQQueueWriter {

    private static final Logger log = LoggerFactory.getLogger(ActiveMQQueueWriter.class);


    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");
        QueueConnection queueConnection = connectionFactory.createQueueConnection();

        QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = queueSession.createQueue("test-queue");

        MessageProducer producer = queueSession.createProducer(queue);

        queueConnection.start();

        TextMessage textMessage = queueSession.createTextMessage("Current time: " + System.currentTimeMillis());

        producer.send(textMessage);
        log.info("Message sent at {}", System.currentTimeMillis());

        producer.close();
        queueSession.close();
        queueConnection.close();
    }

}
