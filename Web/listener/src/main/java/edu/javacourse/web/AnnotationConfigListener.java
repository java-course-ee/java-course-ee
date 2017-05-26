package edu.javacourse.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author Artem Pronchakov artem.pronchakov@ocrv.ru
 */
@WebListener()
public class AnnotationConfigListener implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(AnnotationConfigListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("AnnotationConfigListener has been started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("AnnotationConfigListener has been stopped");
    }
}
