package ru.gs.test.restexample;

import java.util.Date;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/rest")
@Path("/SimpleRestService")
public class SimpleRestService extends Application{
    
    @GET
    @Path("/id/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person sayHello(@PathParam("id") Long id, @PathParam("name") String name) {
        return new Person(id, name, 21, new Date());
    }
}
