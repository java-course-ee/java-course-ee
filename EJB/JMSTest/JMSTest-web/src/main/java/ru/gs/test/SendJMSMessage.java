package ru.gs.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendJMSMessage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext ic = new InitialContext();

            ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/cf/MyTopicCF");
            Topic queue = (Topic) ic.lookup("jms/topic/MyTopic");
            Connection connection = cf.createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            TextMessage message = session.createTextMessage();
            message.setText("Current time: " + System.currentTimeMillis());

            MessageProducer producer = session.createProducer(queue);
            
            producer.send(message);

        } catch (JMSException ex) {
            Logger.getLogger(SendJMSMessage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(SendJMSMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
