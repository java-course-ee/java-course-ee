package edu.javacourse.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Collection;
import java.util.Date;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */

@Stateless
@LocalBean
public class TimerServiceEJB {

    private static final Logger log = LoggerFactory.getLogger(TimerServiceEJB.class);

    @Resource
    private TimerService timerService;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    public void scheduledMethod() {
        log.debug("EJB method scheduled at: {}", new Date());
    }

    @Schedule(second = "*/7", minute = "*", hour = "*", persistent = false)
    public void scheduledMethod2() {
        log.debug("EJB method 2 scheduled at: {}", new Date());
    }

    public Collection<Timer> getAllTimers() {
        return timerService.getAllTimers();
    }

}
