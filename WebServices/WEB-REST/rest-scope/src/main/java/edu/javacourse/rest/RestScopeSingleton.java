package edu.javacourse.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Path("/scopeSingleton")
public class RestScopeSingleton {

    private static final Logger log = LoggerFactory.getLogger(RestScopeSingleton.class);

    public RestScopeSingleton() {
        log.debug("*** Constructing RestScopeSingleton instance");
    }

    @GET
    @Path("/query")
    public Response query() {
        log.debug("\tRestScopeSingleton query invoked");
        return Response.ok().build();
    }

}
