package edu.javacourse.webservice.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Date;

@ApplicationPath("/rest")
@Path("/SimpleRestService")
public class SimpleRestService extends Application {

    @GET
    @Path("/id/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person sayHello(
            @PathParam("id") Long id,
            @PathParam("name") String name) {
        return new Person(id, name, 21, new Date());
    }

    @GET
    @Path("/account")
    @Produces(MediaType.APPLICATION_JSON)
    public Person sayHello2(
            @QueryParam("id") @NotNull Long id,
            @QueryParam("name")String name) {
        throw new NumberFormatException("qwe");
    }

}
