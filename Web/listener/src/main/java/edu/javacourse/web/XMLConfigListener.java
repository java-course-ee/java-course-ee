package edu.javacourse.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
public class XMLConfigListener implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(XMLConfigListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("XMLConfigListener has been started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("XMLConfigListener has been stopped");
    }
}
