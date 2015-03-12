package edu.javacourse.webservice.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.io.File;
import java.net.URISyntaxException;

/**
 * Author: Georgy Gobozov
 * Date: 14.07.13
 */

@ApplicationPath("/rest")
@Path("/get")
public class RestService extends Application {


    @GET
    @Path("/file")
    @Produces("text/plain")
    public Response getFile() throws URISyntaxException {
        File file = new File("{path to text file}");
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition", "attachment; filename='" + file.getName() + "'");
        return response.build();
    }

    @GET
    @Path("/image")
    @Produces("image/png")
    public Response getImage() throws URISyntaxException {
        File file = new File("{path to image}");
        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename='" + file.getName() + "'");
        return response.build();
    }


}
