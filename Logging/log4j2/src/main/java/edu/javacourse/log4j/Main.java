package edu.javacourse.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Artem Pronchakov artem.pronchakov@calisto.email
 */
public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        log.trace("Trace message");
        log.debug("Debug message");
        log.info("Info message");
        log.warn("Warn message");
        log.error("Error message");
        log.fatal("Fatal message");

        String w = "World";
        log.debug("Hello, {}", w);

        log.debug("This is heavy log: {}", () -> {
            String s = "This string can be very difficult to build";
            return s;
        });

    }
}
