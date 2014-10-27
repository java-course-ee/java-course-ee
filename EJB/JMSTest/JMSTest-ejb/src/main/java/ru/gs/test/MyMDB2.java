package ru.gs.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/topic/MyTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MyMDB2 implements MessageListener {
    
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message recieved: MyMDB2, value: " + ((TextMessage)message).getText());
        } catch (JMSException ex) {
            Logger.getLogger(MyMDB2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
