package edu.javacourse.camel.simpleroute;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultMessage;

import java.util.Date;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class InputGenerator implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        DefaultMessage message = new DefaultMessage();
        message.setBody("current time: " + new Date());

        exchange.setOut(message);

    }
}
