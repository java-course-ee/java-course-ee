package edu.javacourse.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ContextService;

/**
 * @author Artem Pronchakov
 */

@Stateless
@LocalBean
public class SimpleEJB {

    private static final Logger log = LoggerFactory.getLogger(SimpleEJB.class);

    @Resource
    private ContextService contextService;

    public void testMethod() {

    }

}
