package edu.javacourse.webservice.rest;

import org.jboss.resteasy.annotations.Form;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */

@ApplicationPath("/rest")
@Path("/hello")
public class RestService extends Application {


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

    @GET
    @Path("/queryMatrix")
    public Response matrixParams(@MatrixParam("from") int from, @MatrixParam("to") int to) {
        return Response.status(200).entity("from = " + from + "      to = " + to).build();
    }

    @POST
    @Path("/addForm")
    public Response queryformParam(@Form Book book) {
        return Response.status(200).entity("id = " + book.getId() + "      name = " + book.getName()).build();
    }

    @GET
    @Path("/queryDefault")
    public Response queryDefault(@QueryParam("age") @DefaultValue("500") int age) {
        return Response.status(200).entity("age = " + age).build();
    }

    @POST
    @Path("/add")
    public Response queryFormParams(@FormParam("name") String name, @FormParam("age") int age) {
        return Response.status(200).entity("New user " + name + " " + age + " created.").build();
    }


}
