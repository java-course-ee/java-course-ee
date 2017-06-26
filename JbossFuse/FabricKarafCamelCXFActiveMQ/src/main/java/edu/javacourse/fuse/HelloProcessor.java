package edu.javacourse.fuse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;

/**
 * Created by JavaCourse on 9/13/2016.
 */
public class HelloProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        MessageContentsList body = exchange.getIn().getBody(MessageContentsList.class);
        String o = (String) body.get(0);
        body.set(0, "Hello " + o);
    }
}
