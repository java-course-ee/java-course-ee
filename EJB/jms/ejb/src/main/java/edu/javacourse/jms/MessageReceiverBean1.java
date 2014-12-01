package edu.javacourse.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "TestMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test")
})
public class MessageReceiverBean1 implements MessageListener {
    
    private static final Logger log = LoggerFactory.getLogger(MessageReceiverBean1.class);

    @PostConstruct
    public void before() {
        log.debug("PostConstruct");
    }

    @PreDestroy
    public void after() {
        log.debug("PreDestroy");
    }

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                Thread.sleep(2000);
                TextMessage textMessage = (TextMessage) message;
                log.debug("Bean 1: {}, {}", textMessage.getText(), Calendar.getInstance().getTime().toString());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

}
