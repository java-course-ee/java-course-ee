package edu.javacourse.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@ServerEndpoint("/helloEndpoint")
public class HelloWebSocketEndpoint {

    private static final Logger log = LoggerFactory.getLogger(HelloWebSocketEndpoint.class);

    public HelloWebSocketEndpoint() {
        log.debug("new HelloWebSocketEndpoint()");
    }

    @OnOpen
    public void open(Session session) {
        log.debug("Hello WebSocket opened: id: {}", session.getId());
    }

    @OnMessage
    public String onMessage(String message) {
        return "Hello " + message;
    }

    @OnClose
    public void close(CloseReason reason) {
        log.debug("Hello WebSocket closed: Reason: ", reason.getReasonPhrase());
    }

}
