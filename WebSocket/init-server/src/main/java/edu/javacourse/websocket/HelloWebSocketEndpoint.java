package edu.javacourse.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@ServerEndpoint("/helloEndpoint")
public class HelloWebSocketEndpoint {

    private static final Logger log = LoggerFactory.getLogger(HelloWebSocketEndpoint.class);

    private ManagedThreadFactory managedThreadFactory;

    public HelloWebSocketEndpoint() {
        log.debug("new HelloWebSocketEndpoint()");
        try {
            InitialContext context = new InitialContext();
            managedThreadFactory = (ManagedThreadFactory) context.lookup("java:jboss/ee/concurrency/factory/default");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void open(Session session) {
        log.debug("Hello WebSocket opened: id: {}", session.getId());
        managedThreadFactory.newThread(new Worker(session)).start();
    }

    class Worker implements Runnable {

        private Session session;

        public Worker(Session session) {
            this.session = session;
        }

        @Override
        public void run() {
            while (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText("Hello client #" + session.getId() + ", server time is: " + new Date());
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    @OnClose
    public void close(CloseReason reason) {
        log.debug("Hello WebSocket closed: Reason: ", reason.getReasonPhrase());
    }

}
