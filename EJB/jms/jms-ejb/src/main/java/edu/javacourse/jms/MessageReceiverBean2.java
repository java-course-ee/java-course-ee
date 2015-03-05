package edu.javacourse.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.Calendar;

@MessageDriven(name = "TestMDB2", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test")
})
public class MessageReceiverBean2 implements MessageListener {
    
    private static final Logger log = LoggerFactory.getLogger(MessageReceiverBean2.class);

    @PostConstruct
    public void before() {
        log.debug("Bean 2 PostConstruct");
    }

    @PreDestroy
    public void after() {
        log.debug("Bean 2 PreDestroy");
    }

    @Resource
    private MessageDrivenContext context;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                Thread.sleep(2000);
                TextMessage textMessage = (TextMessage) message;

                final String text = textMessage.getText();
                log.debug("Bean 2 from queue: {}", text);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

}
