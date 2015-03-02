package edu.javacourse.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@WebServlet(name = "SecurityEJBServlet", urlPatterns = {"/securityEJBServlet"})
public class SecurityEJBServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(SecurityEJB.class);

    @EJB
    private SecurityEJB ejb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.debug("User: {}", req.getUserPrincipal().getName());
        log.debug("User has role 'admin': {}", req.isUserInRole("admin"));
        log.debug("User has role 'secured': {}", req.isUserInRole("secured"));

        try {

            ejb.unsecureMethod();

            ejb.secureMethod();

        } catch (Exception ex) {
            log.error("Error: {}: {}", ex.getClass().getCanonicalName(), ex.getMessage());
        }

    }
}
