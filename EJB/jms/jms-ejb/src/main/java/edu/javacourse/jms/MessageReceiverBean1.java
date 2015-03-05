package edu.javacourse.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(name = "TestMDB1", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/test")
})
public class MessageReceiverBean1 implements MessageListener {
    
    private static final Logger log = LoggerFactory.getLogger(MessageReceiverBean1.class);

    @PostConstruct
    public void before() {
        log.debug("Bean 1 PostConstruct");
    }

    @PreDestroy
    public void after() {
        log.debug("Bean 1 PreDestroy");
    }

    @Resource
    public MessageDrivenContext context;

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                Thread.sleep(2000);
                TextMessage textMessage = (TextMessage) message;

                final String text = textMessage.getText();
                if (text.contains("This is message 3") || text.contains("This is message 5") || text.contains("This is message 7")) {
                    log.debug("*** Bean 1 Throw message with text'"  + text + "' away...");
                    context.setRollbackOnly();
                    return;
                }

                log.debug("Bean 1 from queue: {}", text);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
    }

}
