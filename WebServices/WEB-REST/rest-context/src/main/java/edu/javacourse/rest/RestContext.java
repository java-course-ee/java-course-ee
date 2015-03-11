package edu.javacourse.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;
import java.util.Enumeration;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@ApplicationPath("/rest")
@Path("/context")
public class RestContext extends Application {

    private static final Logger log = LoggerFactory.getLogger(RestContext.class);

    @Context
    private HttpServletRequest request;

    @Context
    private HttpHeaders headers;

    @Context
    private UriInfo uriInfo;

    @Context
    private SecurityContext securityContext;

    @GET
    @Path("/query")
    public void query() {
        final Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            final String parameter = parameterNames.nextElement();
            log.debug("*** Parameter name from Request: {}:{} ", parameter, request.getParameter(parameter));
        }
        log.debug("*** Headers: {} ", headers.getRequestHeaders());
        log.debug("*** UriInfo: {} ", uriInfo.getRequestUri());
        log.debug("*** Is Secure: {} ", securityContext.isSecure());
        log.debug("*** User Principal: {} ", securityContext.getUserPrincipal() != null ? securityContext.getUserPrincipal().getName() : "Anonymous");
    }


}
