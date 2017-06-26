package edu.javacourse.fuse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JavaCourse on 9/13/2016.
 */
public class PrepareDataForSQL implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<String> list = new ArrayList<>();
        list.add("current time: " + System.currentTimeMillis());
        exchange.getIn().setBody(list);
    }
}
