package edu.javacourse.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Calendar;

@MessageDriven(name = "TestMDB4", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "topic/test")
})
public class MessageReceiverBean4 implements MessageListener {
    
    private static final Logger log = LoggerFactory.getLogger(MessageReceiverBean4.class);

    @PostConstruct
    public void before() {
        log.debug("Bean 4 PostConstruct");
    }

    @PreDestroy
    public void after() {
        log.debug("Bean 4 PreDestroy");
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                Thread.sleep(4000);
                TextMessage textMessage = (TextMessage) message;
                log.debug("Bean 4 from topic: {}", textMessage.getText());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

}
