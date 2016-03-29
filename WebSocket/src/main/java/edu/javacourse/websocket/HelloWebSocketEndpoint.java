package edu.javacourse.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@ServerEndpoint("/helloEndpoint")
public class HelloWebSocketEndpoint {

    private static final Logger log = LoggerFactory.getLogger(HelloWebSocketEndpoint.class);

    @OnOpen
    public void open(Session session) {
        log.debug("Hello WebSocket opened: id: {}", session.getId());
    }

    @OnMessage
    public String sayHello(String name) {
        return "Hello " + name + ": " + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
    }

    @OnClose
    public void close(CloseReason reason) {
        log.debug("Hello WebSocket closed: Reason: ", reason.getReasonPhrase());
    }

}
