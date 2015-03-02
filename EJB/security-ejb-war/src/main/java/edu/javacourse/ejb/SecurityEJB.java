package edu.javacourse.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */

@Stateless
@LocalBean
public class SecurityEJB {

    private static final Logger log = LoggerFactory.getLogger(SecurityEJB.class);

    @RolesAllowed({"secured"})
    public void secureMethod() {
        log.debug("This method may invoke only by user with role 'secured'");
    }

    @PermitAll
    public void unsecureMethod() {
        log.debug("This method may invoke any user");
    }

}
