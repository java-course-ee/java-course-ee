package edu.javacourse.fuse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by JavaCourse on 9/7/2016.
 */
public class BodyToUppercaseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(exchange.getIn().getBody(String.class).toUpperCase());
    }
}
