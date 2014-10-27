package edu.javacourse.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * Author: Georgy Gobozov
 * Date: 07.07.13
 */
@WebServlet(name = "firstServlet", urlPatterns = "/first")
public class FirstServlet extends HttpServlet {

    private Logger log = LoggerFactory.getLogger(FirstServlet.class);

    @Resource(mappedName = "jms/GeminiTestQueueFactory")
    private ConnectionFactory connectionQueueFactory;

    @Resource(mappedName = "jms/GeminiTestQueue")
    private Queue queue;

//    @Resource(mappedName = "jms/GeminiTestTopicFactory")
//    private ConnectionFactory connectionTopicFactory;
//
//
//    @Resource(mappedName = "jms/GeminiTestTopic")
//    private Topic topic;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("Servlet started!");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        sendMessageToQueue();

        log.debug("Servlet finished!");
    }

    public void sendMessageToQueue() {
        try {
            Connection connection = connectionQueueFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            for (int i = 0; i < 20; i++) {
                message.setText("This is message " + (i + 1));
                log.debug("Sending message: " + message.getText() + " " + Calendar.getInstance().getTime().toString());
                messageProducer.send(message);
            }
        } catch (JMSException ex) {
            ex.printStackTrace();
            log.debug(ex.getMessage());
        }
    }

//    public void sendMessageToTopic() {
//        try {
//            Connection connection = connectionTopicFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer messageProducer = session.createProducer(topic);
//            TextMessage message = session.createTextMessage();
//            for (int i = 0; i < 10; i++) {
//                message.setText("This is message " + (i + 1));
//                log.debug("Sending message: " + message.getText() + " "+Calendar.getInstance().getTime().toString());
//                messageProducer.send(message);
//            }
//        } catch (JMSException ex) {
//            ex.printStackTrace();
//            log.debug(ex.getMessage());
//        }
//    }
}
