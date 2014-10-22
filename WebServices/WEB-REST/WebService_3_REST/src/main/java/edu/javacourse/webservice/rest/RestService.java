package edu.javacourse.webservice.rest;

import javax.ws.rs.core.Response;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */

@Path("/hello")
public class RestService {


    @GET
    @Path("/say/{something}")
    public Response saySomething(@PathParam("something") String s) {
        return Response.status(200).entity(s).build();
    }

    @GET
    @Path("/query")
    public Response queryParams(@QueryParam("from") int from, @QueryParam("to") int to) {
        return Response.status(200).entity("from = " + from + "      to = " + to).build();
    }


    @POST
    @Path("/add")
    public Response queryFormParams(@FormParam("name") String name, @FormParam("age") int age) {
        return Response.status(200).entity("New user " + name + " " + age + " created.").build();
    }


}
