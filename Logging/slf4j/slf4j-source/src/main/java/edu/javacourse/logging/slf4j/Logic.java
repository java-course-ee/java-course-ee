package edu.javacourse.logging.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class Logic {
    private static final Logger log = LoggerFactory.getLogger(Logic.class);

    public static void someLogic() {
        log.trace("Trace log entry");
        log.debug("Debug log entry");
        log.info("Info log entry");
        log.error("Error log entry");
        log.warn("Warn log entry");

        log.info("This is parametrized log entry. Params are: {}, {}", 45, 89);

        if (log.isInfoEnabled()) {
            log.info("Another Info log entry");
        }
    }
}
