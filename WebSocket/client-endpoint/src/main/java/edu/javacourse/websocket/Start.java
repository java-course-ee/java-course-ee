package edu.javacourse.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
@WebListener
public class Start implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(Start.class);
    private Session session;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("Client endpoint app started");

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        try {
            session = container.connectToServer(HelloClientEndpoint.class, new URI("ws://localhost:8080/init-client/helloEndpoint"));

            session.getBasicRemote().sendText("Valiko");

            Thread.sleep(5000);

            session.getBasicRemote().sendText("Ruben");

            Thread.sleep(5000);

            session.getBasicRemote().sendText("Aristofan");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Client endpoint app stopped");
    }
}
