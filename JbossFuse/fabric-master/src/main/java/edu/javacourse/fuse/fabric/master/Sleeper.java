package edu.javacourse.fuse2.fabric.master;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class Sleeper implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Thread.sleep(500);
    }

}
