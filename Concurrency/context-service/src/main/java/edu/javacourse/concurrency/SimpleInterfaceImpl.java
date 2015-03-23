package edu.javacourse.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Artem Pronchakov
 */
public class SimpleInterfaceImpl implements SimpleInterface {

    private static final Logger log = LoggerFactory.getLogger(SimpleInterfaceImpl.class);

    @Override
    public void doSomething() {
    }
}
