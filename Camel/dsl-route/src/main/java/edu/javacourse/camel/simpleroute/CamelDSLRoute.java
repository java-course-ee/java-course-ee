package edu.javacourse.camel.simpleroute;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Artem Pronchakov <artem.pronchakov@calisto.email>
 */
public class CamelDSLRoute {

    private static final Logger log = LoggerFactory.getLogger(CamelDSLRoute.class);

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();

        final InputGenerator inputGenerator = new InputGenerator();

        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("timer:1s?fixedRate=true&period=1000").process(inputGenerator).transform(simple("${body.toUpperCase()}")).to("log:edu.javacourse.camel?level=INFO");
            }
        });

        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }

}
