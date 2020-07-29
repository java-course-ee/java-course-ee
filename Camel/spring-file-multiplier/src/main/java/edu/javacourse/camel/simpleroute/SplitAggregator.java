package edu.javacourse.camel.simpleroute;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class SplitAggregator implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange _old, Exchange _new) {
        if (_old == null) {
            Integer body = _new.getIn().getBody(Integer.class);
            String s = String.valueOf(body);
            _new.getIn().setBody(s);
            return _new;
        } else {
            Integer body = _new.getIn().getBody(Integer.class);
            String s = String.valueOf(body);

            String oldBody = _old.getIn().getBody(String.class);
            _old.getIn().setBody(oldBody + "\n" + s);
            return _old;
        }
    }
}
