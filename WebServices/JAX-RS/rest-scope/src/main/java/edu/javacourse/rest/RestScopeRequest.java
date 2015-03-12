package edu.javacourse.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
@Path("/scopeRequest")
public class RestScopeRequest {

    private static final Logger log = LoggerFactory.getLogger(RestScopeRequest.class);

    public RestScopeRequest() {
        log.debug("*** Constructing RestScopeRequest instance");
    }

    @GET
    @Path("/query")
    public Response query() {
        log.debug("\tRestScopeRequest query invoked");
        return Response.ok().build();
    }

}
