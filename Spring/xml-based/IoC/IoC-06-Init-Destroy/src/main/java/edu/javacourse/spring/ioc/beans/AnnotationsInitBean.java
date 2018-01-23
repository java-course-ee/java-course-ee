package edu.javacourse.spring.ioc.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class AnnotationsInitBean {

    private static Logger log = LoggerFactory.getLogger(AnnotationsInitBean.class);

    @PostConstruct
    public void annotatedInitMethod() {
        log.debug("");
        log.debug("annotatedInitMethod invoked");
    }

    @PreDestroy
    public void annotatedDestroyMethod() {
        log.debug("");
        log.debug("annotatedDestroyMethod invoked");
    }

}
