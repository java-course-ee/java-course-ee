package edu.javacourse.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.websocket.*;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@ClientEndpoint
public class HelloClientEndpoint {

    private static final Logger log = LoggerFactory.getLogger(HelloClientEndpoint.class);

    public HelloClientEndpoint() {
        log.debug("new HelloClientEndpoint()");
    }

    @OnOpen
    public void open(Session session) {

    }

    @OnMessage
    public void onMessage(String message) {
        log.debug("HelloClientEndpoint received a message: {}", message);
    }

    @OnClose
    public void close(CloseReason reason) {
        log.debug("HelloClientEndpoint closed: Reason: ", reason.getReasonPhrase());
    }

}
